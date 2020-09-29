package com.test.tracker.exception;

public class DriverNotAvailableException extends Exception {
    public DriverNotAvailableException() {
        super("Driver not available at the moment, please try after sometime!!");
    }

    public DriverNotAvailableException(String message) {
        super(message);
    }
}
