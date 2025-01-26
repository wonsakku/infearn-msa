package com.msa.rental.domain.model.vo;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class RentalCardNo {
    private String no;

    public static RentalCardNo createRentalCardNo(){
        UUID uuid = UUID.randomUUID();
        String year = String.valueOf(LocalDate.now().getYear());
        String str = year + "-" + uuid;

        return RentalCardNo.builder()
                .no(str)
                .build();
    }

    public static RentalCardNo sample(){
        return RentalCardNo.createRentalCardNo();
    }

    public static void main(String[] args) {
        System.out.println(RentalCardNo.sample());
    }
}
