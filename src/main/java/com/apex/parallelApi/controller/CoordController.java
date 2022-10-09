package com.apex.parallelApi.controller;

import com.apex.parallelApi.model.Coord;
import com.apex.parallelApi.model.Country;
import com.apex.parallelApi.model.Root;
import com.apex.parallelApi.service.CoordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/weather")
@RequiredArgsConstructor
public class CoordController {

    private final CoordService coordService;

    @GetMapping("/allCoord")
    public List<Coord> getAllCoord(){
        return coordService.getAllCoord();
    }
    
    @GetMapping("/getWeatherData")
    public void getWeatherdata(){
        List<Coord> coordList = coordService.getAllCoord();
        CompletableFuture<Root> completableFuture = null;
        for (Coord coord : coordList) {
                completableFuture = coordService.getWeatherByLatLon(coord.getLat(), coord.getLon());
            }

        List<String> allData;

    }
}
