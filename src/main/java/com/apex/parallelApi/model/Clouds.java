package com.apex.parallelApi.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Clouds {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    @Column(name = "cloude_all")
    public Long all;
}
