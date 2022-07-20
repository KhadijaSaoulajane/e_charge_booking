package com.e_park.booking.controller;


import com.e_park.booking.dtos.*;
import com.e_park.booking.repository.BookingRepository;
import com.e_park.booking.service.BookingService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class BookingController {

    // bookSlot
    // INFOS TO GET FROM REQUEST ==> /booking/{CS_id} , body = {
    /* {
       "card_details": {
            "card_holder": "xxx",
            "card_number":"12345678",
            "card_exp":"12/02/2022",
            "card_cvv":"123"
            },

       "car_details": {
            "model":"xxx",
            "license":"HDUKKS"
            },

        "user_id": "1"
        }
    *
    *
    *
    * */
    // FIRST , Save card details (Microservice payment) ==> /payment/verifyPayment/{user_id} and body card details
    // Save Car details (microservice User management) ==> /saveCar
    // GET Charging station id from request
    // fetch DB for chargin CS with the id
    // edit CS with availability false
    // Create new Booking with booking time = current time
    // save Booking

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }


    @PostMapping(value="/booking/{id}",consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String bookSlot(@PathVariable("id") String cs_id, @RequestBody BookingDto booking_dto) {
        //UserRest returnValue = new UserRest();

       // BookingDto booking_dto = new BookingDto();
        //BeanUtils.copyProperties(dto, booking_dto);

        /* Save Car details
        RestTemplate user_api = new RestTemplate();
        String user_car_reponse = user_api.postForObject(
                "http://172.22.192.43:8080/saveCar",
                new HttpEntity<>(new Car(booking_dto.getModel(),booking_dto.getLicense())),
                String.class);

         */

        //verify Payment
        RestTemplate payment_api = new RestTemplate();
        String payment_response = payment_api.postForObject("/payment/"+booking_dto.getUser_id(),
                new HttpEntity<>(new CreditCard(booking_dto.getCard_holder(),booking_dto.getCard_number(),booking_dto.getCard_exp(),booking_dto.getCard_cvv())),
                String.class);
        if("OK".equals(payment_response)){

            // change availability of CS
            RestTemplate cs_api = new RestTemplate();
            String cs_reponse = cs_api.postForObject(
                    "/charging_station/editCS/"+cs_id,
                    new HttpEntity<>("booked"),
                    String.class);

            // Create Booking
            Booking new_booking = new Booking();
            new_booking.setBooking_time(new SimpleDateFormat("hh:mm a").format(new Date()));
            new_booking.setCs_id(Long.parseLong(cs_id));
            new_booking.setUser_id(Long.parseLong(booking_dto.getUser_id()));

            bookingService.createExam(new_booking);

            return "OK";
        }
        else{
            return"KO";
        }
      //  return returnValue;
    }
}
