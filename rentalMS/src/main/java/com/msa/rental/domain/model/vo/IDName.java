package com.msa.rental.domain.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IDName {

    private String id;
    private String name;

    public static IDName sample(){
        return IDName.builder()
                .id("scant")
                .name("han")
                .build();
    }

    public static void main(String[] args) {
        System.out.println(IDName.sample());
    }
}
