package com.apex.parallelApi.repository;

import com.apex.parallelApi.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface WeatherRepo extends JpaRepository<Weather, Integer> {
}
