package com.test.tracker.service;

import com.test.tracker.domain.Driver;
import com.test.tracker.enums.DriverStatus;

import java.util.List;

public interface DriverService {

    void addDriver(Driver driver);
    void updateDriver(Driver driver);
    List<Driver> getDrivers();
    void updateDriverStatus(Driver driver, DriverStatus driverStatus);
}
