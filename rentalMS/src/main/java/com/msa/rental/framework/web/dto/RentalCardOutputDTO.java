package com.msa.rental.framework.web.dto;

import com.msa.rental.domain.model.RentalCard;
import com.msa.rental.domain.model.RentalItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RentalCardOutputDTO {
    private String rentalCardId;
    private String memberId;
    private String memberName;
    private String rentStatus;
    private Long totalLateFee;
    private Long totalRentalCnt;
    private Long totalReturnCnt;
    private Long totalOverduedCnt;

    public static RentalCardOutputDTO mapToDTO(RentalCard rental){
        RentalCardOutputDTO dto = new RentalCardOutputDTO();
        dto.setRentalCardId(rental.getRentalCardNo().getNo());
        dto.setMemberId(rental.getMember().getId());
        dto.setMemberName(rental.getMember().getName());
        dto.setRentStatus(rental.getRentStatus().toString());
        dto.setTotalRentalCnt(rental.getRentalItemList().stream().count());
        dto.setTotalReturnCnt(rental.getReturnItemList().stream().count());
        dto.setTotalOverduedCnt(rental.getRentalItemList().stream().filter(RentalItem::isOverdued).count());
        return dto;
    }

}
