package com.msa.rental.domain.model;

import com.msa.rental.domain.model.vo.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class RentalItem {

    @Embedded
    private Item item;
    private LocalDate rentDate;
    private boolean overdued;
    private LocalDate overdueDate; // 반납예정일

    public static RentalItem createRentalItem(Item item){
        return RentalItem.builder()
                .item(item)
                .rentDate(LocalDate.now())
                .overdued(false)
                .overdueDate(LocalDate.now().plusDays(14))
                .build();
    }

    public static RentalItem sample(){
        return RentalItem.createRentalItem(Item.sample());
    }




}
