package com.example.arsteam.arduino.controller;

import com.example.arsteam.arduino.dto.ArduinoDto;
import com.example.arsteam.arduino.service.ArduinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/arduino")
public class ArduinoController {

    private ArduinoService arduinoService;

    @Autowired
    public ArduinoController(ArduinoService arduinoService){
        this.arduinoService = arduinoService;
    }

    // 디바이스 측정값 조회
    @GetMapping
    public ResponseEntity getData(@Param("deviceId") String deviceId){
        ArduinoDto.GetResponseDto responseDto = arduinoService.getData(deviceId);

        return new ResponseEntity(responseDto, HttpStatus.OK);
    }

    // 디바이스 신규등록
    @PostMapping("/device")
    public ResponseEntity postDevice(@RequestParam("deviceId") String deviceId ){
            ArduinoDto.DeviceResponseDto response = arduinoService.postDevice(deviceId);

        return new ResponseEntity(response,HttpStatus.CREATED);
    }

    // 습도 저장
    @PatchMapping("/data/humidity")
    public ResponseEntity updateHumidity(@RequestParam("deviceId") String deviceId, @RequestParam("humidity") long humidity){
        ArduinoDto.DataResponseDto responseDto = arduinoService.updateHumidity(deviceId,humidity);

        return new ResponseEntity(responseDto,HttpStatus.OK);
    }

    // 기온 저장
    @PatchMapping("/data/temperature")
    public ResponseEntity updateTemperature(@RequestParam("deviceId") String deviceId,@RequestParam("temperature") long temperature){
        ArduinoDto.DataResponseDto responseDto = arduinoService.updateTemperature(deviceId,temperature);

        return new ResponseEntity(responseDto,HttpStatus.OK);
    }

    // 토양 수분 저장
    @PatchMapping("/data/soilMoisture")
    public ResponseEntity updateSoilMoisture(@RequestParam("deviceId") String deviceId,@RequestParam("soilMoisture") long soilMoisture){
        ArduinoDto.DataResponseDto responseDto = arduinoService.updateSoilMoisture(deviceId,soilMoisture);

        return new ResponseEntity(responseDto,HttpStatus.OK);
    }

    // 수위 저장
    @PatchMapping("/data/waterLevel")
    public ResponseEntity updateWaterLevel(@RequestParam("deviceId") String deviceId,@RequestParam("temperature") long waterLevel){
        ArduinoDto.DataResponseDto responseDto = arduinoService.updateWaterLevel(deviceId,waterLevel);

        return new ResponseEntity(responseDto,HttpStatus.OK);
    }

    // 상의 더 해봐야 할듯
    /*
    @PatchMapping("/data/waterPump")
    public ResponseEntity updateHumidity(){

    }
    @PatchMapping("/data/led")
    public ResponseEntity updateHumidity(){

    }
    @PatchMapping("/data/coolingFan")
    public ResponseEntity updateHumidity(){

    }

     */
}
