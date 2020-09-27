package com.test.tracker.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Data
@MappedSuperclass
public class User implements Serializable {

    private String firstName;
    private String middleName;
    private String lastName;
    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String mobile;
}
