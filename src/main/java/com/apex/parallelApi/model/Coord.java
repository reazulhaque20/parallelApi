package com.apex.parallelApi.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Coord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private double lon;
    private double lat;
}
