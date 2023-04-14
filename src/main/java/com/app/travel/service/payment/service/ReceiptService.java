package com.app.travel.service.payment.service;


import com.app.travel.service.payment.client.BookingClient;
import com.app.travel.service.payment.model.Receipt;
import com.app.travel.service.payment.repository.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiptService {
    @Autowired
    private ReceiptRepository receiptRepository;

    @Autowired
    private BookingClient bookingClient;


    public Receipt addReceipt(Receipt receipt) {
        if(bookingClient.getBooking(receipt.getBookingRef())==null){ // handle as error
            return null;
        }
        return receiptRepository.save(receipt);
    }

    public Receipt getReceipt() {
        return receiptRepository.findAll().stream().findFirst().get();
    }
}
