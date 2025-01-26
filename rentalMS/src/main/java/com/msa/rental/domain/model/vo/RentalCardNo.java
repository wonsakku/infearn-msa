package com.msa.rental.domain.model.vo;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class RentalCardNo implements Serializable {
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
