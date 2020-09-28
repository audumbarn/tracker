package com.test.tracker.vo;

import com.test.tracker.domain.Customer;
import com.test.tracker.domain.Location;
import com.test.tracker.enums.BookingStatus;
import lombok.Data;

@Data
public class BookingDetails {
    private Customer customer;
    private Location pickupLocation;
    private BookingStatus status;
}
