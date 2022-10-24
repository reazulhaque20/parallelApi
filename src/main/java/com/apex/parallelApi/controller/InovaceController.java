package com.apex.parallelApi.controller;

import com.apex.parallelApi.service.InovaceService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("api/inovace/")
@RequiredArgsConstructor
public class InovaceController {

    private final InovaceService inovaceService;

    private static final Logger log = LogManager.getLogger(InovaceController.class);

    @GetMapping("getLog/")
    public void getLog() throws ExecutionException, InterruptedException {
        Instant start = Instant.now();
        List<CompletableFuture<Map<String, String>>> allFutures = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            allFutures.add(inovaceService.getDeviceLog());
        }

        CompletableFuture.allOf(allFutures.toArray(new CompletableFuture[0])).join();

        for (int i = 0; i < 5; i++) {
            System.out.println("response: " + allFutures.get(i).get().toString());
        }

        Instant finish = Instant.now();

        long timeElapsed = Duration.between(start, finish).toMillis();

        System.out.println("Total time: " + timeElapsed + " ms");
    }
}
