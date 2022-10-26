//package com.apex.parallelApi.service;
//
//import com.apex.parallelApi.model.*;
//import com.apex.parallelApi.repository.*;
//import lombok.RequiredArgsConstructor;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.CompletableFuture;
//
//@Service
//@RequiredArgsConstructor
//public class CoordServiceImpl implements CoordService {
//
//    private final CoordRepo coordRepo;
//    private final RootRepo rootRepo;
//    private final CloudsRepo cloudsRepo;
//    private final MainRepo mainRepo;
//    private final WeatherRepo weatherRepo;
//    private final SysRepo sysRepo;
//    private final WindRepo windRepo;
//
//    private static final Logger logger = LogManager.getLogger(CoordServiceImpl.class);
//    @Override
//    public List<Coord> getAllCoord() {
//        return coordRepo.findAll();
//    }
//    List<Root> rootList = new ArrayList<>();
//    @Override
////    @Async
//    public CompletableFuture<String> getWeatherByLatLon(double lat, double lon) {
//        RestTemplate restTemplate = new RestTemplate();
//        List<Root> rootList = new ArrayList<>();
//        logger.info("Get Weather Service Data......");
//        String url = "https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon +"&appid=892a3cc7296959eb9b022b411d643960&units=metric";
//        logger.info("Get Weather Service URL: " + url);
//        Root response = new Root();
//        try {
//            response = restTemplate.getForObject(url, Root.class);
//        }catch(Exception exception){
//            logger.error("API Call Error: " + exception);
//            dataLoader(lat, lon);
//        }
//        logger.info("Received Weather Service Response: " + response);
//        Main main = response.getMain();
//        main.setLat(lat);
//        main.setLon(lon);
//        mainRepo.save(main);
////        cloudsRepo.save(response.getClouds());
//        for(Weather w : response.getWeather()) {
//            w.setLat(lat);
//            w.setLon(lon);
//            weatherRepo.save(w);
//        }
//        Sys sys = response.getSys();
//        sys.setLat(lat);
//        sys.setLon(lon);
//        sysRepo.save(sys);
//        Wind wind = response.getWind();
//        wind.setLat(lat);
//        wind.setLon(lon);
//        windRepo.save(wind);
//        return CompletableFuture.completedFuture("");
//    }
//
//    private void dataLoader(double lat, double lon){
//        Main main = new Main();
//        main.setTemp(31.18);
//        main.setFeels_like(33.13);
//        main.setTemp_min(31.18);
//        main.setTemp_max(31.18);
//        main.setPressure(1009);
//        main.setHumidity(51);
//        main.setLat(lat);
//        main.setLon(lon);
//        mainRepo.save(main);
//
//        Weather weather = new Weather();
//        weather.setMain("Clouds");
//        weather.setDescription("scattered clouds");
//        weather.setIcon("03d");
//        weather.setLat(lat);
//        weather.setLon(lon);
//        weatherRepo.save(weather);
//
//        Sys sys = new Sys();
//        sys.setType(0);
//        sys.setCountry("BD");
//        sys.setSunrise(1665878675);
//        sys.setSunset(1665920284);
//        sys.setLat(lat);
//        sys.setLon(lon);
//        sysRepo.save(sys);
//
//        Wind wind = new Wind();
//        wind.setSpeed(2.02);
//        wind.setDeg(331);
//        wind.setLat(lat);
//        wind.setLon(lon);
//        windRepo.save(wind);
//    }
//}
