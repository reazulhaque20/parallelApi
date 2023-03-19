package com.apex.parallelApi.service;

import okhttp3.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class LogCollector {

    RestTemplate restTemplate = new RestTemplate();
    private static final Logger logger = LogManager.getLogger(LogCollector.class);


    @Async
    public void getLogData(){
//        logger.info("Collecting Log Data From Device......");
//        String url = "http://192.168.4.24/ISAPI/AccessControl/AcsEvent?format=json";
//        OkHttpClient client = new OkHttpClient().newBuilder().build();
//        MediaType mediaType = MediaType.parse("application/json");
//        RequestBody body = RequestBody.create(mediaType, "{\r\n   \"AcsEventCond\":{\r\n      \"searchID\":\"3242s34\",\r\n      \"searchResultPosition\":0,\r\n      \"numOfMatches\": 300,\r\n      \"maxResults\":600,\r\n      \"major\":0,\r\n      \"minor\":0,\r\n      \"startTime\":\"2022-09-09T17:30:08+08:00\",\r\n      \"endTime\":\"2022-12-12T17:30:08+08:00\"\r\n   }\r\n}");
//        Request request = new Request.Builder()
//                .url("192.168.4.24:80/ISAPI/AccessControl/AcsEvent?format=json")
//                .method("POST", body)
//                .addHeader("Content-Type", "application/json")
//                .build();
//        try {
//            Response response = client.newCall(request).execute();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}
