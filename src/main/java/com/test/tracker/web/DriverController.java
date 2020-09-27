package com.test.tracker.web;

import com.test.tracker.domain.Driver;
import com.test.tracker.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @GetMapping("/test")
    public String test() {
        return "Welcome to tracking app!";
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
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
