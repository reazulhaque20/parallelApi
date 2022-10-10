package com.apex.parallelApi.model;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "root")
public class Root {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "base")
    private String base;

    @Column(name = "visibility")
    private Long visibility;

    @Column(name = "dt")
    private Long dt;

    @Column(name = "timezone")
    private Long timezone;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "cod")
    private Long cod;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "coord")
    private Coord coord;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "main")
    private Main main;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "wind")
    private Wind wind;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "clouds")
    private Cloud clouds;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sys")
    private Sys sys;

    @OneToMany(mappedBy = "root")
    private Set<Weather> weathers = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Long getVisibility() {
        return visibility;
    }

    public void setVisibility(Long visibility) {
        this.visibility = visibility;
    }

    public Long getDt() {
        return dt;
    }

    public void setDt(Long dt) {
        this.dt = dt;
    }

    public Long getTimezone() {
        return timezone;
    }

    public void setTimezone(Long timezone) {
        this.timezone = timezone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCod() {
        return cod;
    }

    public void setCod(Long cod) {
        this.cod = cod;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Cloud getClouds() {
        return clouds;
    }

    public void setClouds(Cloud clouds) {
        this.clouds = clouds;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public Set<Weather> getWeathers() {
        return weathers;
    }

    public void setWeathers(Set<Weather> weathers) {
        this.weathers = weathers;
    }

}