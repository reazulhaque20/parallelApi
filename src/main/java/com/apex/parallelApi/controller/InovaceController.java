package com.apex.parallelApi.controller;

import com.apex.parallelApi.model.RootData;
import com.apex.parallelApi.service.InovaceService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("api/inovace")
@RequiredArgsConstructor
@EnableScheduling
public class InovaceController {

    private final InovaceService inovaceService;

//    private final HikVisionService hikVisionService;

    private static final Logger log = LogManager.getLogger(InovaceController.class);

    @GetMapping("getLog/")
    public void getLog(){
    }

    @Transactional
    @GetMapping("/getData")
    @Scheduled(fixedRate = 30000)
    public void getData() {
        CompletableFuture<RootData> completableFuture;
//        CompletableFuture<AcsEvent> acsEventCompletableFuture;
        try {
            completableFuture = inovaceService.getDeviceLog();
//            acsEventCompletableFuture = hikVisionService.getHikVisionLogData();
            System.out.println(completableFuture);
//            System.out.println(acsEventCompletableFuture);
//            CompletableFuture.allOf(completableFuture, acsEventCompletableFuture).join();
        }catch(Exception exception){
            log.error("Error: " + exception);
        }
    }

    @GetMapping("/test")
    public String test(){
        return "Test";
    }
}
