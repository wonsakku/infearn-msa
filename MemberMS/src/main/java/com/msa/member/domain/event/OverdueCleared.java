package com.msa.member.domain.event;

import com.msa.member.domain.vo.IDName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OverdueCleared implements Serializable {
    private IDName idName;
    private long point;
}
