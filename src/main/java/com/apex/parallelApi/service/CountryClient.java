package com.apex.parallelApi.service;

import com.apex.parallelApi.model.Country;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class CountryClient {
    RestTemplate restTemplate = new RestTemplate();
    private static final Logger LOGGER = LogManager.getLogger(CountryClient.class);
    @Async
    public CompletableFuture<List<Country>> getCountriesByLanguage(String language) {
        LOGGER.info("Get Country By Language Service.");
        String url = "https://restcountries.com/v2/lang/" + language + "?fields=name";
        LOGGER.info("Get Country By Language Service URL: " + url);
        Country[] response = restTemplate.getForObject(url, Country[].class);
        LOGGER.info("Get Country By Language Service Response: " + response);
        return CompletableFuture.completedFuture(Arrays.asList(response));
    }

    @Async
    public CompletableFuture<List<Country>> getCountriesByRegion(String region) {
        LOGGER.info("Get Country By Region Service.");
        String url = "https://restcountries.com/v2/region/" + region + "?fields=name";
        LOGGER.info("Get Country By Region Service URL: " + url);
        Country[] response = restTemplate.getForObject(url, Country[].class);
        LOGGER.info("Get Country By Region Service Response: " + response);
        return CompletableFuture.completedFuture(Arrays.asList(response));
    }
}