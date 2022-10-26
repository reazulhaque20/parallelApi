package com.apex.parallelApi.controller;

import com.apex.parallelApi.model.LogData;
import com.apex.parallelApi.model.RootData;
import com.apex.parallelApi.service.InovaceService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("api/inovace")
@RequiredArgsConstructor
@EnableScheduling
public class InovaceController {

    private final InovaceService inovaceService;

    private static final Logger log = LogManager.getLogger(InovaceController.class);

    @GetMapping("getLog/")
    public void getLog() throws ExecutionException, InterruptedException {
//        Instant start = Instant.now();
//
//        CompletableFuture<String> completableFuture = null;
//        List<CompletableFuture<ResponseEntity<String>>> allFutures = new ArrayList<>();
//        try {
//                for (int i = 0; i < 5; i++) {
////                    allFutures.add(inovaceService.getDeviceLog());
//                    completableFuture.
//                }
//        }catch(Exception exception){
//            log.error("Error: " + exception);
//        }
//
//
//
////        for (int i = 0; i < 5; i++) {
////            allFutures.add(inovaceService.getDeviceLog());
////        }
////
////        CompletableFuture.allOf(allFutures.toArray(new CompletableFuture[0])).join();
////
////        for (int i = 0; i < 5; i++) {
////            System.out.println("response: " + allFutures.get(i).get().toString());
////        }
//
//        Instant finish = Instant.now();
//
//        long timeElapsed = Duration.between(start, finish).toMillis();
//
//        System.out.println("Total time: " + timeElapsed + " ms");
    }

    @Transactional
    @GetMapping("/getData")
    @Scheduled(fixedRate = 30000)
    public void getData() throws JSONException {

        String response = "";
        CompletableFuture<RootData> completableFuture = null;
        try {
            completableFuture = inovaceService.getDeviceLog();
        }catch(Exception exception){
            log.error("Error: " + exception);
        }
    }
}
