package com.duoc.Scoutball.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.duoc.Scoutball.dto.WeatherDTO;

@Service
public class WeatherService {

     @Autowired
    @Qualifier("weatherWebClient")
    private WebClient weatherWebClient;

     public WeatherDTO obtenerClima(double latitude, double longitude) {
        return weatherWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/v1/forecast")
                        .queryParam("latitude", latitude)
                        .queryParam("longitude", longitude)
                        .queryParam("current_weather", true)
                        .build())
                .retrieve()
                .bodyToMono(WeatherDTO.class)
                .block();
    }
}
