package com.app.travel.service.payment.controller;


import com.app.travel.service.payment.service.CouponsService;
import com.app.travel.service.payment.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/payment")
public class PaymentController {
    @Autowired
    private CouponsService couponsService;
    @Autowired
    private ReceiptService receiptService;
}
