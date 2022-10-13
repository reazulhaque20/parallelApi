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

    private static final Logger logger = LogManager.getLogger(CoordServiceImpl.class);
    @Override
    public List<Coord> getAllCoord() {
        return coordRepo.findAll();
    }
    List<Root> rootList = new ArrayList<>();
    @Override
//    @Async
    public CompletableFuture<String> getWeatherByLatLon(double lat, double lon) {
        RestTemplate restTemplate = new RestTemplate();
        List<Root> rootList = new ArrayList<>();
        logger.info("Get Weather Service Data......");
        String url = "https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon +"&appid=892a3cc7296959eb9b022b411d643960&units=metric";
        logger.info("Get Weather Service URL: " + url);
        Root response = restTemplate.getForObject(url, Root.class);
        logger.info("Received Weather Service Response: " + response);
        Main main = response.getMain();
        main.setLat(lat);
        main.setLon(lon);
        mainRepo.save(main);
//        cloudsRepo.save(response.getClouds());
        for(Weather w : response.getWeather()) {
            w.setLat(lat);
            w.setLon(lon);
            weatherRepo.save(w);
        }
        Sys sys = response.getSys();
        sys.setLat(lat);
        sys.setLon(lon);
        sysRepo.save(sys);
        Wind wind = response.getWind();
        wind.setLat(lat);
        wind.setLon(lon);
        windRepo.save(wind);
        return CompletableFuture.completedFuture("");
    }
}
