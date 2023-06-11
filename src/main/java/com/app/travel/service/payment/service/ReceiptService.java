package com.app.travel.service.payment.service;


import com.app.travel.service.payment.client.BookingClient;
import com.app.travel.service.payment.client.UserClient;
import com.app.travel.service.payment.exceptions.exceptions.ObjectDoesNotExistInDb;
import com.app.travel.service.payment.model.Coupons;
import com.app.travel.service.payment.model.Receipt;
import com.app.travel.service.payment.repository.ReceiptRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReceiptService {
    @Autowired
    private ReceiptRepository receiptRepository;

    @Autowired
    private BookingClient bookingClient;

    @Autowired
    private UserClient userClient;

    @Autowired
    private CouponsService couponsService;


    private Coupons crateACouponForBooking(Integer numberOfBookings){
        var stat = numberOfBookings/5.;
        if(Math.abs(stat - Math.round(stat)) < 0.001){
            return couponsService.addCoupon(new Coupons(
                    0,
                    20,
                    new Date(),
                    new Date(Long.MAX_VALUE),
                    true,
                    null
            ));
        }
        return null;
    }

    public Receipt addReceipt(Receipt receipt) {
        try{
            var booking = bookingClient.getBooking(receipt.getBookingId());

        }catch (FeignException e){
            if(e.status() == 500) throw e;
            throw new ObjectDoesNotExistInDb("No data with id " + receipt.getBookingId() + "!", "booking");
        }
        try{
            var user = userClient.getUser(receipt.getUserId());
        }catch (FeignException e){
            if(e.status() == 500) throw e;
            throw new ObjectDoesNotExistInDb("No data with id " + receipt.getBookingId() + "!", "user");
        }

        var numberOfBookings = receiptRepository.getNumberOfCreatedBookings(receipt.getUserId());

        var coupon = crateACouponForBooking(numberOfBookings);
        receipt.setCoupon(coupon);
        return receiptRepository.save(receipt);
    }

    public Receipt getReceipt() {
        return receiptRepository.findAll().stream().findFirst().get();
    }
}
