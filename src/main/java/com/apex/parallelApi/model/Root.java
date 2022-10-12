package com.apex.parallelApi.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Root {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "coord_id")
    private Coord coord;
    private Weather[] weather;
    private String base;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "main_id")
    private Main main;
    private long visibility;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "wind_id")
    private Wind wind;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "clouds_id")
    private Clouds clouds;
    private long dt;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sys_id")
    private Sys sys;
    private long timezone;
    private String name;
    private long cod;
}
