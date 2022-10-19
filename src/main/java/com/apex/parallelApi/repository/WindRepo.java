package com.apex.parallelApi.repository;

import com.apex.parallelApi.model.Wind;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WindRepo extends JpaRepository<Wind, Integer> {

    @Query("SELECT u FROM Wind u WHERE u.lat=:lat and u.lon=:lon")
    List<Wind> finByLatLon(@Param("lat") double lat, @Param("lon") double lon);
}
