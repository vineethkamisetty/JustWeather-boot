package com.vineethkamisetty.api.controller;

import com.vineethkamisetty.api.constants.URI;
import com.vineethkamisetty.api.entity.CityWeather;
import com.vineethkamisetty.api.service.WeatherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController     // has both @Controller and @ResponseBody
@Api(tags = "DB APIs")
@RequestMapping(value = URI.WEATHER)
public class WeatherDBInfoController {

    private WeatherService weatherService;

    public WeatherDBInfoController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Get Weather Data", notes = "Stores the Weather Data form a mocker into database")
    //consume and produce attribute not required in new version of spring and need to check how to change localhost:8080
    public void create(@RequestBody CityWeather cityWeather) {
        System.out.println(cityWeather.toString());
        weatherService.create(cityWeather);
    }
}
