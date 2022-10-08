package com.apex.parallelApi.service;

import com.apex.parallelApi.model.Country;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CountryClient {
    RestTemplate restTemplate = new RestTemplate();

    @Async
    public List<Country> getCountriesByLanguage(String language) {
        String url = "https://restcountries.com/v3.1/lang/" + language + "?fields=name";
        Country[] response = restTemplate.getForObject(url, Country[].class);

        return Arrays.asList(response);
    }

    @Async
    public List<Country> getCountriesByRegion(String region) {
        String url = "https://restcountries.com/v3.1/region/" + region + "?fields=name";
        Country[] response = restTemplate.getForObject(url, Country[].class);

        return Arrays.asList(response);
    }
}