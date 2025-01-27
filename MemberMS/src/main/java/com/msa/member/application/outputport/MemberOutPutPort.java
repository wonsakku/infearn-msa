package com.msa.member.application.outputport;

import com.msa.member.domain.Member;
import com.msa.member.domain.vo.IDName;

public interface MemberOutPutPort {
    public Member loadMember(long memberNo);
    public Member loadMemberByIdName(IDName idName);
    public Member saveMember(Member member);
}