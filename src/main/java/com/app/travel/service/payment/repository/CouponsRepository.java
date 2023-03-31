package com.app.travel.service.payment.repository;

import com.app.travel.service.payment.model.Coupons;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponsRepository extends JpaRepository<Coupons, Integer> {
}
