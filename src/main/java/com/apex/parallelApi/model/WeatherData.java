package com.apex.parallelApi.model;

import java.util.ArrayList;

public class WeatherData {
    Coord CoordObject;
    ArrayList<Weather> weather = new ArrayList<>();
    private String base;
    Main MainObject;
    private float visibility;
    Wind WindObject;
    Clouds CloudsObject;
    private float dt;
    Sys SysObject;
    private float timezone;
    private float id;
    private String name;
    private float cod;
}
