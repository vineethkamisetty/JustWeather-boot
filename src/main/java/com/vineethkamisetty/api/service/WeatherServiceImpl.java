package com.vineethkamisetty.api.service;

import com.vineethkamisetty.api.database.DBRepository;
import com.vineethkamisetty.api.entity.CityWeather;
import com.vineethkamisetty.api.exception.NotFound;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {

    private DBRepository repository;

    public WeatherServiceImpl(DBRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void create(CityWeather cityWeather) { // returning void because it is reading from kinda read-only endpoint
        System.out.println("Entry: " + cityWeather);
        CityWeather cw = repository.save(cityWeather);
        System.out.println("Saved Entry: " + cw);
    }

    @Transactional(readOnly = true)
    public List<String> allCities() {
        List<String> cityWeathers = repository.findDistinctCity();
        System.out.println("cityWeathers: " + cityWeathers);
        return cityWeathers;
    }

    @Transactional(readOnly = true)
    public CityWeather getWeather(String city) {
        CityWeather cityWeather = repository.findFirstByCityOrderByUidDesc(city);
        if (cityWeather == null)
            throw new NotFound(city + " is not present in database");
        return cityWeather;
    }

    @Transactional(readOnly = true)
    public CityWeather getWeatherProperty(String city, String property) {
        CityWeather cityWeather = repository.findFirstByCityOrderByUidDesc(city);
        if (cityWeather == null)
            throw new NotFound(city + " is not present in database");
        return cityWeather;
    }

    @Transactional(readOnly = true)
    public CityWeather get_Hr_Avg_Weather(String city) {
        CityWeather cityWeather = repository.get_Hr_Avg_Weather(city);
        if (cityWeather == null)
            throw new NotFound(city + " is not present in database");
        return cityWeather;
    }

    @Transactional(readOnly = true)
    public CityWeather get_Day_Avg_Weather(String city) {
        CityWeather cityWeather = repository.get_Day_Avg_Weather(city);
        if (cityWeather == null)
            throw new NotFound(city + " is not present in database");
        return cityWeather;
    }
}
