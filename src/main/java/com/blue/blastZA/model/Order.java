package com.blue.blastZA.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "orders")
public class Order {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_id;
    @Column
    private int customer_id;
    @Column
    private Date order_date;
    @Column
    private int status;
    @Column
    private String comments;
    @Column
    private Date shipped_date;
    @Column
    private int shipper_id;
}
