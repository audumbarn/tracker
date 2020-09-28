package com.test.tracker.web;

import com.test.tracker.domain.Booking;
import com.test.tracker.service.BookingService;
import com.test.tracker.vo.BookingDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/book")
    Booking bookCab(@RequestBody BookingDetails bookingDetails) {
        return bookingService.book(bookingDetails);
    }

}
