package com.apex.parallelApi.model;

import lombok.Data;
import java.util.ArrayList;

@Data
public class Root {
    public Long id;
    public Coord coord;
    public ArrayList<Weather> weather;
    public String base;
    public Main main;
    public Long visibility;
    public Wind wind;
    public Clouds clouds;
    public Long dt;
    public Sys sys;
    public Long timezone;
    public String name;
    public Long cod;
}
