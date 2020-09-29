package com.test.tracker.service;

import com.test.tracker.domain.Booking;
import com.test.tracker.domain.Driver;
import com.test.tracker.enums.BookingStatus;
import com.test.tracker.enums.DriverStatus;
import com.test.tracker.exception.BookingNotFoundException;
import com.test.tracker.exception.DriverNotAvailableException;
import com.test.tracker.repository.BookingRepository;
import com.test.tracker.repository.DriverRepository;
import com.test.tracker.vo.BookingDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.test.tracker.enums.BookingStatus.COMPLETED;

/**
 * Service layer for booking a cab, updating booking
 */
@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private DriverService driverService;

    /**
     * Creates booking with given details, gets the nearest driver
     * @param bookingDetails
     * @return
     * @throws Exception
     */
    @Override
    @Transactional
    public synchronized Booking book(BookingDetails bookingDetails) throws DriverNotAvailableException {
        Driver d = driverRepository.getDriver(bookingDetails.getPickupLocation().getLat(), bookingDetails.getPickupLocation().getLon());

        if(d == null) {
            throw new DriverNotAvailableException();
        }

        Booking b = new Booking();
        b.setDriver(d);
        b.setStartLocation(bookingDetails.getPickupLocation());
        b.setStatus(BookingStatus.BOOKED);
        b.setCustomer(bookingDetails.getCustomer());
        d.setStatus(DriverStatus.BUSY);

        driverRepository.save(d);
        bookingRepository.save(b);

        return b;
    }

    /**
     * Update booking, currently implemented only for completing trip
     * @param booking booking to update
     * @return
     */
    @Override
    public synchronized Booking updateBooking(Booking booking) throws BookingNotFoundException {
         if (COMPLETED.equals(booking.getStatus())) {
            Booking b = bookingRepository.findById(booking.getId()).orElseThrow(BookingNotFoundException::new);

            b.setStatus(COMPLETED);

            driverService.updateDriverStatus(b.getDriver(), DriverStatus.AVAILABLE);
            return bookingRepository.save(b);
        }
        return null;
    }
}
