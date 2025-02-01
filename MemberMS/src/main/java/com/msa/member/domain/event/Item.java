package com.msa.member.domain.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Item {
    private Integer no;
    private String title;

    public static Item sample(){
        return new Item(10, "노인과 바다");
    }
}
