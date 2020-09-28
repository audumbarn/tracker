package com.test.tracker.domain;

import com.test.tracker.enums.DriverStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "driver")
public class Driver extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @OneToMany(mappedBy = "driver")
    private List<Booking> bookings;

    @Enumerated(EnumType.STRING)
    private DriverStatus status;

    @Embedded
    private Location location;
}
