package com.apex.parallelApi.model;

import javax.persistence.*;

@Entity
@Table(name = "clouds")
public class Cloud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "cloude_all", nullable = false)
    private Integer cloudeAll;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCloudeAll() {
        return cloudeAll;
    }

    public void setCloudeAll(Integer cloudeAll) {
        this.cloudeAll = cloudeAll;
    }

}