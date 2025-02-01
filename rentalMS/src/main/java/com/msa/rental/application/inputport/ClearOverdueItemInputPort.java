package com.msa.rental.application.inputport;

import com.msa.rental.application.outputport.EventOutputPort;
import com.msa.rental.application.outputport.RentalCardOutputPort;
import com.msa.rental.application.usecase.ClearOverdueItemUseCase;
import com.msa.rental.domain.model.RentalCard;
import com.msa.rental.domain.model.event.OverdueCleared;
import com.msa.rental.framework.web.dto.ClearOverdueInfoDTO;
import com.msa.rental.framework.web.dto.RentalResultOutputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ClearOverdueItemInputPort implements ClearOverdueItemUseCase {

    private final RentalCardOutputPort rentalCardOutputPort;
    private final EventOutputPort eventOutputPort;


    @Override
    public RentalResultOutputDTO clearOverdue(ClearOverdueInfoDTO dto) {
        RentalCard rentalCard = rentalCardOutputPort.loadRentalCard(dto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("해당 카드가 존재하지 않습니다."));

        rentalCard.makeAvailableRental(dto.getPoint());

        // 이벤트 생성 및 발행
        OverdueCleared overdueClearedEvent = RentalCard.createOverdueClearedEvent(rentalCard.getMember(), dto.getPoint());
        eventOutputPort.occurOverdueClearedEvent(overdueClearedEvent);

        return RentalResultOutputDTO.mapToDTO(rentalCard);
    }
}
