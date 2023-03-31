package com.app.travel.service.payment.repository;

import com.app.travel.service.payment.model.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptRepository extends JpaRepository<Receipt, Integer> {
}
