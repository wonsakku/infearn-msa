package com.msa.rental.domain.model.vo;

import lombok.*;

import javax.persistence.Embeddable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class LateFee {
    private long point;

    public LateFee addPoint(long point){
        return new LateFee(this.point + point);
    }

    public LateFee removePoint(long point){
        if(point > this.point){
            throw new RuntimeException("보유한 포인트보다 커서 삭제할 수 없습니다.");
        }
        return new LateFee(this.point - point);
    }

    public static LateFee createLateFee(){
        return new LateFee(0);
    }

    public static LateFee sample(){
        return new LateFee(100);
    }

}
