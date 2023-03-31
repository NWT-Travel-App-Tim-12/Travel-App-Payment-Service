package com.app.travel.service.payment.service;


import com.app.travel.service.payment.repository.CouponsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponsService {
    @Autowired
    private CouponsRepository couponsRepository;
}
