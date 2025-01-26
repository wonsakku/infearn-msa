package com.msa.rental.framework.web.dto;

import com.msa.rental.domain.model.RentalItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RentItemOutputDTO {
    private Integer itemNo;
    private String itemTitle;
    private LocalDate rentDate;
    private boolean overdued;
    private LocalDate overdueDate;

    public static RentItemOutputDTO mapToDTO(RentalItem rentalItem){
        RentItemOutputDTO dto = new RentItemOutputDTO();
        dto.setItemNo(rentalItem.getItem().getNo());
        dto.setItemTitle(rentalItem.getItem().getTitle());
        dto.setRentDate(rentalItem.getRentDate());
        dto.setOverdued(rentalItem.isOverdued());
        dto.setOverdueDate(rentalItem.getOverdueDate());
        return dto;
    }
}
