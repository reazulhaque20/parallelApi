package com.apex.parallelApi.service;

import com.apex.parallelApi.model.Coord;
import com.apex.parallelApi.model.Root;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface CoordService {
    List<Coord> getAllCoord();
    List<Root> getWeatherByLatLon(String lat, String lon);
}
