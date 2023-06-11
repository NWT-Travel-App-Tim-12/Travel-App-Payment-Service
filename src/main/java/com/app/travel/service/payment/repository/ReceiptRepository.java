package com.app.travel.service.payment.repository;

import com.app.travel.service.payment.model.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Integer> {

    @Query(
            "SELECT count(*) FROM Receipt r where r.userId = ?1"

    )
    Integer getNumberOfCreatedBookings(Integer userId);
}
