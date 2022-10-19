package com.apex.parallelApi.repository;

import com.apex.parallelApi.model.Sys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysRepo extends JpaRepository<Sys, Long> {

    @Query("SELECT u FROM Sys u WHERE u.lat=:lat and u.lon=:lon")
    List<Sys> finByLatLon(@Param("lat") double lat, @Param("lon") double lon);
}
