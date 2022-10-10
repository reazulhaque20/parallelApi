package com.apex.parallelApi.model;

import javax.persistence.*;

@Entity
@Table(name = "main")
public class Main {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "temp", nullable = false)
    private Integer temp;

    @Column(name = "feels_like", nullable = false)
    private Integer feelsLike;

    @Column(name = "temp_min", nullable = false)
    private Integer tempMin;

    @Column(name = "temp_max", nullable = false)
    private Integer tempMax;

    @Column(name = "pressure", nullable = false)
    private Integer pressure;

    @Column(name = "humidity", nullable = false)
    private Integer humidity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTemp() {
        return temp;
    }

    public void setTemp(Integer temp) {
        this.temp = temp;
    }

    public Integer getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(Integer feelsLike) {
        this.feelsLike = feelsLike;
    }

    public Integer getTempMin() {
        return tempMin;
    }

    public void setTempMin(Integer tempMin) {
        this.tempMin = tempMin;
    }

    public Integer getTempMax() {
        return tempMax;
    }

    public void setTempMax(Integer tempMax) {
        this.tempMax = tempMax;
    }

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

}