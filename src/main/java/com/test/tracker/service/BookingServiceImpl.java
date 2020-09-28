package com.test.tracker.service;

import com.test.tracker.domain.Booking;
import com.test.tracker.domain.Driver;
import com.test.tracker.repository.BookingRepository;
import com.test.tracker.repository.DriverRepository;
import com.test.tracker.vo.BookingDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public Booking book(BookingDetails bookingDetails) {
        Driver d = driverRepository.getDriver(bookingDetails.getPickupLocation().getLat(), bookingDetails.getPickupLocation().getLon());
        Booking b = new Booking();
        b.setDriver(d);

        return b;
    }
}
