package com.msa.rental.application.inputport;

import com.msa.rental.application.outputport.RentalCardOutputPort;
import com.msa.rental.application.usecase.InquiryUseCase;
import com.msa.rental.framework.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class InquiryInputPort implements InquiryUseCase {
    
    private final RentalCardOutputPort rentalCardOutputPort;
    
    @Override
    public Optional<RentalCardOutputDTO> getRentalCard(UserInputDTO userInputDTO) {
        return rentalCardOutputPort.loadRentalCard(userInputDTO.getUserId())
                .map(RentalCardOutputDTO::mapToDTO);
    }

    @Override
    public Optional<List<RentItemOutputDTO>> getAllRentItem(UserInputDTO userInputDTO) {
        return rentalCardOutputPort.loadRentalCard(userInputDTO.getUserId())
                .map(loadCard -> loadCard.getRentalItemList()
                        .stream()
                        .map(RentItemOutputDTO::mapToDTO)
                        .collect(Collectors.toList())
                );
    }

    @Override
    public Optional<List<ReturnItemOutputDTO>> getAllReturnItem(UserItemInputDTO userItemInputDTO) {
        return rentalCardOutputPort.loadRentalCard(userItemInputDTO.getUserId())
                .map(loadCard -> loadCard.getReturnItemList()
                        .stream()
                        .map(ReturnItemOutputDTO::mapToDTO)
                        .collect(Collectors.toList())
                );
    }
}
