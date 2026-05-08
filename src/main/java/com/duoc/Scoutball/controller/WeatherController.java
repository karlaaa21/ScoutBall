package com.duoc.Scoutball.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.duoc.Scoutball.service.WeatherService;
import com.duoc.Scoutball.dto.WeatherDTO;

@RestController
@RequestMapping("/api/v1/clima")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;
    
    @GetMapping
    public ResponseEntity<WeatherDTO> clima(
            @RequestParam(defaultValue = "-33.45") double lat,
            @RequestParam(defaultValue = "-70.65") double lon) {

        System.out.println("[WeatherController] -> clima lat=" + lat + ", lon=" + lon);        
        WeatherDTO resultado = weatherService.obtenerClima(lat, lon);
        return ResponseEntity.ok(resultado);
    }





}
