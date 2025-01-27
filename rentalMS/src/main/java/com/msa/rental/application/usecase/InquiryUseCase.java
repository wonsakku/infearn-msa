package com.msa.rental.application.usecase;

import com.msa.rental.framework.web.dto.*;

import java.util.List;
import java.util.Optional;

public interface InquiryUseCase {
    Optional<RentalCardOutputDTO> getRentalCard(UserInputDTO userInputDTO);
    Optional<List<RentItemOutputDTO>> getAllRentItem(UserInputDTO userInputDTO);
    Optional<List<ReturnItemOutputDTO>> getAllReturnItem(UserInputDTO userInputDTO);
}
