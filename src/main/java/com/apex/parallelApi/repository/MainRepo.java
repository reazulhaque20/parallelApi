package com.apex.parallelApi.repository;

import com.apex.parallelApi.model.Main;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MainRepo extends JpaRepository<Main, Integer> {

    @Query("SELECT u FROM Main u WHERE u.lat=:lat and u.lon=:lon")
    List<Main> finByLatLon(@Param("lat") double lat, @Param("lon") double lon);
}
