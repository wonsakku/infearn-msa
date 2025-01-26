package com.msa.rental.framework.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserItemInputDTO {
    private String userId;
    private String userNm;
    private Integer itemId;
    private String itemTitle;
}
