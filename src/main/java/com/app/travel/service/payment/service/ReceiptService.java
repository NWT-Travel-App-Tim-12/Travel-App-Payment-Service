package com.app.travel.service.payment.service;


import com.app.travel.service.payment.repository.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiptService {
    @Autowired
    private ReceiptRepository receiptRepository;
}