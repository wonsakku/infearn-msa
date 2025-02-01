package com.msa.rental.framework.web;

import com.msa.rental.application.usecase.*;
import com.msa.rental.framework.web.dto.*;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RentalController {

    private final RentItemUseCase rentItemUseCase;
    private final ReturnItemUserCase returnItemUserCase;
    private final CreateRentalCardUseCase createRentalCardUseCase;
    private final OverdueItemUseCase overdueItemUseCase;
    private final ClearOverdueItemUseCase clearOverdueItemUseCase;
    private final InquiryUseCase inquiryUseCase;


    @ApiOperation(value = "도서카드 생성",notes = "사용자정보 -> 도서카드정보")
    @PostMapping("/RentalCard")
    public ResponseEntity<RentalCardOutputDTO> createRentalCard(@RequestBody UserInputDTO userInputDTO){
        RentalCardOutputDTO createRentalCard = createRentalCardUseCase.createRentalCard(userInputDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createRentalCard);
    }

    @ApiOperation(value = "도서카드 조회",notes = "사용자정보(id) -> 도서카드정보")
    @GetMapping("/RentalCard/{userId}")
    public ResponseEntity<RentalCardOutputDTO> getRentalCard(@PathVariable String userId){
        Optional<RentalCardOutputDTO> rentalCard = inquiryUseCase.getRentalCard(new UserInputDTO(userId, ""));
        return ResponseEntity.ok(rentalCard.get());
    }

    @ApiOperation(value = "대여도서목록 조회",notes = "사용자정보(id) -> 대여도서목록 조회")
    @GetMapping("/RentalCard/{userId}/rentbook")
    public ResponseEntity<List<RentItemOutputDTO>> getAllRentItem(@PathVariable String userId){
        Optional<List<RentItemOutputDTO>> allRentItem = inquiryUseCase.getAllRentItem(new UserInputDTO(userId, ""));
        return ResponseEntity.ok(allRentItem.get());
    }

    @ApiOperation(value = "반납도서목록 조회",notes = "사용자정보(id) -> 반납도서목록 조회")
    @GetMapping("/RentalCard/{userId}/returnbook")
    public ResponseEntity<List<ReturnItemOutputDTO>> getAllReturnItem(@PathVariable String userId){
        Optional<List<ReturnItemOutputDTO>> allReturnItem = inquiryUseCase.getAllReturnItem(new UserInputDTO(userId, ""));
        return ResponseEntity.ok(allReturnItem.get());
    }

    @ApiOperation(value = "대여기능",notes = "사용자정보,아이템정보1 -> 도서카드정보 ")
    @PostMapping("/RentalCard/rent")
    public ResponseEntity<RentalCardOutputDTO> renItem(@RequestBody UserItemInputDTO dto){
        RentalCardOutputDTO rentalCardOutputDTO = rentItemUseCase.renItem(dto);
        return ResponseEntity.ok(rentalCardOutputDTO);
    }

    @ApiOperation(value = "반납기능",notes = "사용자정보,아이템정보1 -> 도서카드정보 ")
    @PostMapping("/RentalCard/return")
    public ResponseEntity<RentalCardOutputDTO> returnItem(@RequestBody UserItemInputDTO userItemInputDTO) {
        RentalCardOutputDTO rentalCardOutputDTO = returnItemUserCase.returnItem(userItemInputDTO);
        return ResponseEntity.ok(rentalCardOutputDTO);
    }

    @ApiOperation(value = "연체기능",notes = "사용자정보,아이템정보1 -> 도서카드정보 ")
    @PostMapping("/RentalCard/overdue")
    public ResponseEntity<RentalCardOutputDTO> overdueItem(@RequestBody
                                                           UserItemInputDTO userItemInputDTO)  {
        RentalCardOutputDTO rentalCardOutputDTO =
                overdueItemUseCase.overDueItem(userItemInputDTO);
        return ResponseEntity.ok(rentalCardOutputDTO);
    }


    @ApiOperation(value = "연체해제기능",notes = "사용자정보,포인트 -> 도서카드정보 ")
    @PostMapping("/RentalCard/clearoverdue")
    public ResponseEntity<RentalResultOutputDTO> clearOverdueItem(@RequestBody ClearOverdueInfoDTO clearOverdueInfoDTO) {
        RentalResultOutputDTO rentalResultOuputDTO = clearOverdueItemUseCase.clearOverdue(clearOverdueInfoDTO);
        return ResponseEntity.ok(rentalResultOuputDTO);
    }
}








