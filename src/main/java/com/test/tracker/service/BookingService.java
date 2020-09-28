package com.test.tracker.service;

import com.test.tracker.domain.Booking;
import com.test.tracker.vo.BookingDetails;

public interface BookingService {
    Booking book(BookingDetails bookingDetails);

}
