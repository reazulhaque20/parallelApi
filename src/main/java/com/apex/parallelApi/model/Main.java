package com.apex.parallelApi.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Main {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public Long temp;
    public Long feels_like;
    public Long temp_min;
    public Long temp_max;
    public Long pressure;
    public Long humidity;
}
