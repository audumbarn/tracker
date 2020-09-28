package com.test.tracker.web;

import com.test.tracker.domain.Driver;
import com.test.tracker.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverService driverService;


    @PostMapping(value = "/add")
    public void addDriver(@RequestBody Driver driver) {
        driverService.addDriver(driver);
    }

    @PutMapping("/update")
    public void updateDriver(@RequestBody Driver driver) {
        driverService.updateDriver(driver);
    }

    @GetMapping(value = "/getAll")
    public List<Driver> getAllDrivers() {
        return driverService.getDrivers();
    }

}
