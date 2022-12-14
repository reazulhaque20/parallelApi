//package com.apex.parallelApi.controller;
//
//import com.apex.parallelApi.model.Coord;
//import com.apex.parallelApi.model.Root;
//import com.apex.parallelApi.service.CoordService;
//
//import lombok.RequiredArgsConstructor;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.boot.configurationprocessor.json.JSONException;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.CompletableFuture;
//
//@RestController
//@RequestMapping("api/weather")
//
////@EnableScheduling
//@RequiredArgsConstructor
//public class CoordController {
//
//    private final CoordService coordService;
//
//    private static final Logger logger = LogManager.getLogger(CoordController.class);
//    @GetMapping("/allCoord")
//    public List<Coord> getAllCoord(){
//        return coordService.getAllCoord();
//    }
//
////    @Transactional
//    @GetMapping("/getWeatherData")
////    @Scheduled(fixedRate = 4000)
//    public void getWeatherdata() throws JSONException {
//        List<Coord> coordList = coordService.getAllCoord();
//        List<Root> rootList = new ArrayList<>();
//        Root root = new Root();
//        String response = "";
//        CompletableFuture<String> completableFuture = null;
//        try {
//                for (Coord coord : coordList) {
//                    completableFuture = coordService.getWeatherByLatLon(coord.getLat(), coord.getLon());
//                    rootList.add(root);
//                }
//        }catch(Exception exception){
//            logger.error("Error: " + exception);
//        }
//    }
//}
