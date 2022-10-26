//package com.apex.parallelApi.repository;
//
//import com.apex.parallelApi.model.Main;
//import com.apex.parallelApi.model.Weather;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface WeatherRepo extends JpaRepository<Weather, Integer> {
//
//    @Query("SELECT u FROM Weather u WHERE u.lat=:lat and u.lon=:lon")
//    List<Weather> finByLatLon(@Param("lat") double lat, @Param("lon") double lon);
//}
