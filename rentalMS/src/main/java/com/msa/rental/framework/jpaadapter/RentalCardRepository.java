package com.msa.rental.framework.jpaadapter;

import com.msa.rental.domain.model.RentalCard;
import com.msa.rental.domain.model.vo.RentalCardNo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RentalCardRepository extends JpaRepository<RentalCard, RentalCardNo> {

    @Query("SELECT m FROM RentalCard m WHERE m.member.id = :id")
    Optional<RentalCard> findByMemberId(@Param("id") String memberId);

    @Query("SELECT m FROM RentalCard m WHERE m.rentalCardNo.no = :id")
    Optional<RentalCard> findById(@Param("id") Long rentalCardId);
}
