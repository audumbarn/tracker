package com.test.tracker.domain;

import com.test.tracker.enums.BookingStatus;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private BookingStatus status;

    @ManyToOne
    @JoinColumn(name="driver_id")
    private Driver driver;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @Embedded
    @AttributeOverrides({
                    @AttributeOverride(name="lat", column = @Column(name="start_lat")),
                    @AttributeOverride(name="lon", column = @Column(name="start_lon")),
            @AttributeOverride(name="address", column = @Column(name="start_address"))
    })
    private Location startLocation;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="lat", column = @Column(name="drop_lat")),
            @AttributeOverride(name="lon", column = @Column(name="drop_lon")),
            @AttributeOverride(name="address", column = @Column(name="drop_address"))
    })
    private Location dropLocation;

}
