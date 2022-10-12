package com.apex.parallelApi.repository;

import com.apex.parallelApi.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepo extends JpaRepository<Weather, Integer> {
}
