package com.msa.rental.domain.model;

import com.msa.rental.domain.model.vo.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RentalCard {

    private RentalCardNo rentalCardNo;
    private IDName member;
    private RentStatus rentStatus;
    private LateFee lateFee;
    private List<RentalItem> rentalItemList = new ArrayList<>();
    private List<ReturnItem> returnItemList = new ArrayList<>();

    public static RentalCard sample(){
        RentalCard rentalCard = new RentalCard();
        rentalCard.setRentalCardNo(RentalCardNo.createRentalCardNo());
        rentalCard.setMember(IDName.sample());
        rentalCard.setRentStatus(RentStatus.RENT_AVAILABLE);
        rentalCard.setLateFee(LateFee.sample());
        return rentalCard;
    }

    private void addRentalItem(RentalItem rentalItem){
        this.rentalItemList.add(rentalItem);
    }

    private void removeRentalItem(RentalItem rentalItem){
        this.rentalItemList.remove(rentalItem);
    }

    private void addReturnItem(ReturnItem returnItem){
        this.returnItemList.add(returnItem);
    }

}



