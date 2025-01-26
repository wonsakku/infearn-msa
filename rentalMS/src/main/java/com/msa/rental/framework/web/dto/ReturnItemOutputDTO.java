package com.msa.rental.framework.web.dto;

import com.msa.rental.domain.model.RentalItem;
import com.msa.rental.domain.model.vo.Item;
import com.msa.rental.domain.model.vo.ReturnItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ReturnItemOutputDTO {

    private Integer itemNo;
    private String itemTitle;
    private LocalDate returnDate;

    public static ReturnItemOutputDTO mapToDTO(ReturnItem rentalItem){
        ReturnItemOutputDTO dto = new ReturnItemOutputDTO();
        Item item = rentalItem.getRentalItem().getItem();
        dto.setItemNo(item.getNo());
        dto.setItemTitle(item.getTitle());
        dto.setReturnDate(rentalItem.getReturnDate());
        return dto;
    }


}
