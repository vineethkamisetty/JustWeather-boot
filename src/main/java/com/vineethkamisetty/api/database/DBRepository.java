package com.vineethkamisetty.api.database;

import com.vineethkamisetty.api.entity.CityWeather;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface DBRepository extends Repository<CityWeather, Long> {

    CityWeather save(CityWeather cityWeather);

    @Query(value = "SELECT DISTINCT c.city FROM CityWeather c")
    List<String> findDistinctCity();

    CityWeather findFirstByCityOrderByUidDesc(String city);

    @Query(value = "SELECT c FROM CityWeather c WHERE c.city=:city ORDER BY c.uid DESC")
    CityWeather get_Hr_Avg_Weather(String city);

    @Query(value = "SELECT c FROM CityWeather c WHERE c.city=:city ORDER BY c.uid DESC")
    CityWeather get_Day_Avg_Weather(String city);

}
