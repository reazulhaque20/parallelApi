package com.apex.parallelApi.service;

import com.apex.parallelApi.model.Coord;
import com.apex.parallelApi.model.Country;
import com.apex.parallelApi.model.Root;
import com.apex.parallelApi.repository.CoordRepo;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class CoordServiceImpl implements CoordService {

    private final CoordRepo coordRepo;
    RestTemplate restTemplate = new RestTemplate();
    private static final Logger logger = LogManager.getLogger(CoordServiceImpl.class);
    @Override
    public List<Coord> getAllCoord() {
        return coordRepo.findAll();
    }


    @Override
    @Async
    public CompletableFuture<Root> getWeatherByLatLon(String lat, String lon) {
        logger.info("Get Weather Service Data......");
        String url = "https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon +"&appid=892a3cc7296959eb9b022b411d643960&units=metric";
        logger.info("Get Weather Service URL: " + url);
        Root response = restTemplate.getForObject(url, Root.class);
        logger.info("Received Weather Service Response: " + response);
        return CompletableFuture.completedFuture((response));
    }
}
