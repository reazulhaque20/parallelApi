package com.apex.parallelApi.service;

import com.apex.parallelApi.model.*;
import com.apex.parallelApi.repository.*;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class CoordServiceImpl implements CoordService {

    private final CoordRepo coordRepo;
    private final RootRepo rootRepo;
    private final CloudsRepo cloudsRepo;
    private final MainRepo mainRepo;
    private final WeatherRepo weatherRepo;
    private final SysRepo sysRepo;
    private final WindRepo windRepo;
    RestTemplate restTemplate = new RestTemplate();
    private static final Logger logger = LogManager.getLogger(CoordServiceImpl.class);
    @Override
    public List<Coord> getAllCoord() {
        return coordRepo.findAll();
    }
    List<Root> rootList = new ArrayList<>();
    @Override
    @Async
    public CompletableFuture<String> getWeatherByLatLon(double lat, double lon) {
        List<Root> rootList = new ArrayList<>();
        logger.info("Get Weather Service Data......");
        String url = "https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon +"&appid=892a3cc7296959eb9b022b411d643960&units=metric";
        logger.info("Get Weather Service URL: " + url);
        Root response = restTemplate.getForObject(url, Root.class);
        logger.info("Received Weather Service Response: " + response);
//        cloudRepo.save(response.getClouds());
        mainRepo.save(response.getMain());
//        cloudsRepo.save(response.getClouds());
        for(Weather w : response.getWeather()) {
            weatherRepo.save(w);
        }
        sysRepo.save(response.getSys());
        windRepo.save(response.getWind());
        return CompletableFuture.completedFuture("");
    }
}
