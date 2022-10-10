package com.apex.parallelApi.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Sys {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public Long type;
    public String country;
    public Long sunrise;
    public Long sunset;
}
