package com.example.arsteam.arduino.controller;

import com.example.arsteam.arduino.dto.ArduinoDto;
import com.example.arsteam.arduino.service.ArduinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/android")
public class AndroidController {

    private ArduinoService arduinoService;

    @Autowired
    public AndroidController(ArduinoService arduinoService){
        this.arduinoService = arduinoService;
    }

    // waterPump 상태 변경
    @PatchMapping("/waterPump")
    public ResponseEntity switchingStatusWaterPump(@RequestParam(value = "deviceId",defaultValue = "1") long deviceId ){
        ArduinoDto.GetResponseDto result = arduinoService.switchingStatusWaterPump(deviceId);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    // led 상태 변경
    @PatchMapping("/led")
    public ResponseEntity switchingStatusLed(@RequestParam(value = "deviceId",defaultValue = "1") long deviceId ){
        ArduinoDto.GetResponseDto result = arduinoService.switchingStatusLed(deviceId);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    // coolingFan 상태 변경
    @PatchMapping("/coolingFan")
    public ResponseEntity switchingStatusCoolingFan(@RequestParam(value = "deviceId",defaultValue = "1") long deviceId ){
        ArduinoDto.GetResponseDto result = arduinoService.switchingStatusCoolingFan(deviceId);
        return new ResponseEntity(result, HttpStatus.OK);
    }
}
