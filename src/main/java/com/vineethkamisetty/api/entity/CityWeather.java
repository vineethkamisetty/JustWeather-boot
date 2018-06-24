package com.vineethkamisetty.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Map;

@Entity
public class CityWeather {

    @Id
    @GeneratedValue
    private long uid;
    @JsonProperty("city")       //tells jackson to map 'city' attribute in json to this property
    private String city;
    @JsonProperty("description")    // need to check how to do with jsonfilter
    private String description;
    @JsonProperty("humidity")
    private int humidity;
    @JsonProperty("pressure")
    private int pressure;
    @JsonProperty("temperature")
    private int temperature;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @JsonProperty("timestamp")
    private String timestamp;
    private double speed;
    private int degree;

    @JsonProperty("wind")
    private void unpack(Map<String, Object> wind) {
        System.out.println(wind.get("speed") + " " + wind.get("degree"));
        this.speed = (Double) wind.get("speed");
        this.degree = (Integer) wind.get("degree");

    }

    @Override
    public String toString() {
        return "CityWeather{" +
                "uid='" + uid + '\'' +
                ", city='" + city + '\'' +
                ", description='" + description + '\'' +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                ", temperature=" + temperature +
                ", timestamp='" + timestamp + '\'' +
                ", speed=" + speed +
                ", degree=" + degree +
                '}';
    }


    public String getProperty(String property) {
        if ("temperature".equals(property)) {
            return "Temperature at " + city + " is " + temperature;
        } else if ("humidity".equals(property)) {
            return "Humidity at " + city + " is " + humidity;
        } else if ("wind".equals(property)) {
            return "Wind in " + city + " speed is " + speed + " and direction is " + degree;
        } else if ("pressure".equals(property)) {
            return "Pressure at " + city + " is " + pressure;
        }
        return "The selected property is not available. Please select among Temperature, Humidity, Wind or Pressure";
    }
}
