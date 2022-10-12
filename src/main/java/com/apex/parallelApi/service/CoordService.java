package com.apex.parallelApi.service;

import com.apex.parallelApi.model.Coord;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface CoordService {
    List<Coord> getAllCoord();
    CompletableFuture<String> getWeatherByLatLon(double lat, double lon);
}
