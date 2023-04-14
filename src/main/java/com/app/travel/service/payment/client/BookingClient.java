package com.app.travel.service.payment.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "booking-service")
public interface BookingClient {

    @GetMapping(path = "/booking/{id}")
    public BookingClientModel getBooking(@PathVariable Integer id);

}
