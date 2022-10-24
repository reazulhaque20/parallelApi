package com.apex.parallelApi.service;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class InovaceService {

    private RestTemplate restTemplate;
    private static final Logger log = LogManager.getLogger(InovaceService.class);
    
    @Async
    public CompletableFuture<Map<String, String>> getDeviceLog() {
        final String serviceUrl = "http://192.168.17.50/api/v1/logs/";

        HttpHeaders headers = new HttpHeaders();
        HttpEntity requestEntity = new HttpEntity<>(headers);

        Map<String, String> uriVariables = new HashMap<>();

        uriVariables.put("start", "2022-09-1200:00:58");
        uriVariables.put("end", "2022-09-1316:10:00");
        uriVariables.put("api_token", "e9b4-bb9c-7bab-1be8-bc33-0dbd-15a3-6cb4-2b6f-c6df-34c7-03fb-d5bb-3271-4ae0-2f5b");
        uriVariables.put("order_direction", "desc");

//        final String response = restTemplate.getForObject(msgServiceUrl, String.class);
        ResponseEntity<Map> response = restTemplate.exchange(serviceUrl, HttpMethod.GET, requestEntity, Map.class, uriVariables);
        log.info("Inovace API Response: " + response);
        return CompletableFuture.completedFuture(response.getBody());
    }
}
