package com.test.tracker.domain;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Location {
    private String address;
    private Double lat;
    private Double lon;

}
