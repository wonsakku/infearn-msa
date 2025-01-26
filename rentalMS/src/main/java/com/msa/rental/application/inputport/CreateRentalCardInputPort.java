package com.msa.rental.application.inputport;

import com.msa.rental.application.outputport.RentalCardOutputPort;
import com.msa.rental.application.usecase.CreateRentalCardUseCase;
import com.msa.rental.domain.model.RentalCard;
import com.msa.rental.domain.model.vo.IDName;
import com.msa.rental.framework.web.dto.RentalCardOutputDTO;
import com.msa.rental.framework.web.dto.UserInputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateRentalCardInputPort implements CreateRentalCardUseCase {

    private final RentalCardOutputPort rentalCardOutputPort;

    @Override
    public RentalCardOutputDTO createRentalCard(UserInputDTO owner) {
        // service 레이어는 도메인에 비즈니스 로직을 위임하도록 흐름제어 기능만
        RentalCard rentalCard = RentalCard.createRentalCard(new IDName(owner.getUserId(), owner.getUserNm()));
        RentalCard save = rentalCardOutputPort.save(rentalCard);
        return RentalCardOutputDTO.mapToDTO(save);
    }
}
