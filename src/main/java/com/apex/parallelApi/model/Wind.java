package com.apex.parallelApi.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Wind {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private double speed;
    private long deg;
    private double lat;
    private double lon;
}
