package com.app.travel.service.payment.controller;


import com.app.travel.service.payment.model.Coupons;
import com.app.travel.service.payment.model.Receipt;
import com.app.travel.service.payment.service.CouponsService;
import com.app.travel.service.payment.service.ReceiptService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/payment")
public class PaymentController {
    @Autowired
    private CouponsService couponsService;
    @Autowired
    private ReceiptService receiptService;


    @PostMapping(path = "")
    public @ResponseBody ResponseEntity<Coupons> addCoupon(@RequestBody @Valid Coupons coupons) {
        return new ResponseEntity<>(couponsService.addCoupon(coupons), HttpStatus.OK);
    }


    @PostMapping(path = "")
    public @ResponseBody ResponseEntity<Receipt> addReceipt(@RequestBody @Valid Receipt receipt) {
        return new ResponseEntity<>(receiptService.addReceipt(receipt), HttpStatus.OK);
    }


}
