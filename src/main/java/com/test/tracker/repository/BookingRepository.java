package com.test.tracker.repository;

import com.test.tracker.domain.Booking;
import com.test.tracker.enums.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    Booking findByStatus(BookingStatus status);
}
