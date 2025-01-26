package com.msa.rental.domain.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private Integer no;
    private String title;

    public static Item sample(){
        return new Item(10, "노인과 바다");
    }
}
