package com.app.travel.service.payment.service;


import com.app.travel.service.payment.client.BookingClient;
import com.app.travel.service.payment.exceptions.exceptions.ObjectDoesNotExistInDb;
import com.app.travel.service.payment.model.Receipt;
import com.app.travel.service.payment.repository.ReceiptRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiptService {
    @Autowired
    private ReceiptRepository receiptRepository;

    @Autowired
    private BookingClient bookingClient;


    public Receipt addReceipt(Receipt receipt) {
        try{
            var booking = bookingClient.getBooking(receipt.getBookingRef());
        }catch (FeignException e){
            if(e.status() == 500) throw e;
            throw new ObjectDoesNotExistInDb("No data with id " + receipt.getBookingRef() + "!", "bookingRef");
        }
        return receiptRepository.save(receipt);
    }

    public Receipt getReceipt() {
        return receiptRepository.findAll().stream().findFirst().get();
    }
}
