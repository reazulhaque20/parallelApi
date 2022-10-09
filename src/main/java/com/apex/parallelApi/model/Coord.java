package com.apex.parallelApi.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "coord")
@Data
public class Coord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String lat;
    private String lon;
}
