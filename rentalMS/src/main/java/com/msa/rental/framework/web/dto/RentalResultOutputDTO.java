package com.msa.rental.framework.web.dto;

import com.msa.rental.domain.model.RentalCard;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RentalResultOutputDTO {
    public String userId;
    public String userNm;
    public Integer rentedCount;
    public long totalLateFee;

    public static RentalResultOutputDTO mapToDTO(RentalCard rental){
        RentalResultOutputDTO dto = new RentalResultOutputDTO();
        dto.setUserId(rental.getMember().getId());
        dto.setUserNm(rental.getMember().getName());
        dto.setRentedCount(rental.getRentalItemList().size());
        dto.setTotalLateFee(rental.getLateFee().getPoint());
        return dto;
    }
}
