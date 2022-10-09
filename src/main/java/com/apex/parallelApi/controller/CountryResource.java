package com.apex.parallelApi.controller;

import com.apex.parallelApi.model.Country;
import com.apex.parallelApi.service.CountryClient;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Component
@RestController
@RequiredArgsConstructor
public class CountryResource {

    private final CountryClient countryClient;
    private static final Logger LOGGER = LogManager.getLogger(CountryResource.class);

//    public CountryResource(CountryClient countryClient) {
//        this.countryClient = countryClient;
//    }

    @GetMapping("/getAllCountry")
    public List<String> getAllEuropeanFrenchSpeakingCountries() throws Throwable {
        LOGGER.info("Get All Country List API.");
        CompletableFuture<List<Country>> countriesByLanguageFuture = countryClient.getCountriesByLanguage("spa");
        LOGGER.info("Country By Language: " + countriesByLanguageFuture);
        CompletableFuture<List<Country>> countriesByRegionFuture = countryClient.getCountriesByRegion("europe");
        LOGGER.info("Country By Region: " + countriesByRegionFuture);
        List<String> europeanFrenchSpeakingCountries;
//        CompletableFuture.allOf(allFutures.toArray(new CompletableFuture[0])).join();
        try {
            europeanFrenchSpeakingCountries = new ArrayList<>(countriesByLanguageFuture.get().stream().map(Country::getName).collect(Collectors.toList()));
            europeanFrenchSpeakingCountries.addAll(countriesByRegionFuture.get().stream().map(Country::getName).collect(Collectors.toList()));
        } catch (Throwable e) {
            throw e.getCause();
        }
        return europeanFrenchSpeakingCountries;
    }
}