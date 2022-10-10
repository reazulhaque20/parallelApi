package com.apex.parallelApi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "coord")
public class Coord {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "lat", nullable = false, length = 45)
    private String lat;

    @Column(name = "lon", nullable = false, length = 45)
    private String lon;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

}