package com.e_park.booking.service;

import com.e_park.booking.dtos.Booking;
import com.e_park.booking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    private final BookingRepository bookingRepo;

    @Autowired
    public BookingService(BookingRepository bookingRepo) {
        this.bookingRepo = bookingRepo;
    }

    public Booking createExam(Booking booking) {
        return bookingRepo.save(booking);
    }
}
