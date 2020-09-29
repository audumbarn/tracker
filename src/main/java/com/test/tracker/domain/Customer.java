package com.test.tracker.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "customer")
@EqualsAndHashCode(callSuper = true)
public class Customer extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

}
