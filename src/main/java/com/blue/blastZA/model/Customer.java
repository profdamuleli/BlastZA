package com.blue.blastZA.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.Nullable;

import java.util.Date;

@Getter @Setter @ToString
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int customer_id;
    @Column
    private String first_name;
    @Column
    private String last_name;
    @Column
    private Date birth_date;
    @Column
    private String phone;
    @Column
    private String address;
    @Column
    private String city;
    @Column
    private String state;
    @Column
    private int points;
}
