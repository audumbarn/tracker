package com.test.tracker.service;

import com.test.tracker.domain.Driver;
import com.test.tracker.enums.DriverStatus;
import com.test.tracker.repository.DriverRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    @Override
    public void updateDriverStatus(Driver driver, DriverStatus driverStatus) {
        Optional<Driver> driverOpt = driverRepository.findById(driver.getId());

        if (driverOpt.isPresent()) {
            Driver d = driverOpt.get();
            d.setStatus(driverStatus);

            driverRepository.save(d);
        }
    }
}
