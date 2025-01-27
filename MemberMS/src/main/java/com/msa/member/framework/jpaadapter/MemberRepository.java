package com.msa.member.framework.jpaadapter;

import com.msa.member.domain.Member;
import com.msa.member.domain.vo.IDName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findMemberByIdName(IDName idName);
}
