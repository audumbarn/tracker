package com.test.tracker.service;

import com.test.tracker.domain.Driver;
import com.test.tracker.repository.DriverRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DriverServiceImpl  implements DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public void addDriver(Driver driver) {
        driverRepository.save(driver);
    }

    @Override
    public void updateDriver(Driver driver) {
        driverRepository.save(driver);
    }

    @Override
    public List<Driver> getDrivers() {
        return driverRepository.findAll();
    }
}
