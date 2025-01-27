package com.msa.member.domain;

import com.msa.member.domain.vo.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private Long MemberNo;
    private IDName idName;
    private PassWord password;
    private Email email;
    private List<Authority> authorities = new ArrayList<>();
    private Point point;


    public static Member registerMember(IDName idName,PassWord pwd,Email email){
        Member member = new Member();
        member.setIdName(idName);
        member.setPassword(pwd);
        member.setEmail(email);
        member.setPoint( Point.createPoint());
        member.addAuthority(new Authority(UserRole.USER));
        return member;
    }
    private void addAuthority(Authority authority) {
        this.authorities.add(authority);
    }
    public long savePoint(long point) {
        return this.point.addPoint(point);
    }

    public long usePoint(long point) {
        return this.point.removePoint(point);
    }
    public Member login(IDName idName, PassWord password){ return this;}
    public void logout(IDName idName){}

}
