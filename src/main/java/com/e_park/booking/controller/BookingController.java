package com.e_park.booking.controller;


import com.e_park.booking.dtos.*;
import com.e_park.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }


    @GetMapping(value="/saveBooking",consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String bookSlot(@RequestParam("chargingStationId") String chargingStationId,
                           @RequestParam("userId") String userId,
                           @RequestParam("cardHolderName") String cardHolderName,
                           @RequestParam("cardNumber") String cardNumber,
                           @RequestParam("expDate") String expDate,
                           @RequestParam("cvv") String cvv) {

            Booking new_booking = new Booking(userId,chargingStationId,cardHolderName,cardNumber,expDate,cvv);
            bookingService.saveBooking(new_booking);

            return "success";
        }


}
