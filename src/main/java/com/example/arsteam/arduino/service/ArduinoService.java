package com.example.arsteam.arduino.service;

import com.example.arsteam.arduino.dto.ArduinoDto;
import com.example.arsteam.arduino.entity.Device;
import com.example.arsteam.arduino.entity.Measures;
import com.example.arsteam.arduino.mapper.ArduinoMapper;
import com.example.arsteam.arduino.repository.ArduinoDeviceRepository;
import com.example.arsteam.arduino.repository.ArduinoMeasuresRepository;
import com.example.arsteam.exception.BusinessLogicException;
import com.example.arsteam.exception.ExceptionCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ArduinoService {
    private ArduinoDto arduinoDto;
    private ArduinoMapper arduinoMapper;
    private ArduinoDeviceRepository arduinoDeviceRepository;
    private ArduinoMeasuresRepository arduinoMeasuresRepository;

    @Autowired
    public ArduinoService(ArduinoDeviceRepository arduinoDeviceRepository,ArduinoMeasuresRepository arduinoMeasuresRepository,ArduinoMapper arduinoMapper){
        this.arduinoDeviceRepository = arduinoDeviceRepository;
        this.arduinoMeasuresRepository = arduinoMeasuresRepository;
        this.arduinoMapper = arduinoMapper;
    }

    public Device findDevice(long deviceId){
        Device device =  arduinoDeviceRepository.findByDeviceId(deviceId)
                .orElseThrow(()-> new BusinessLogicException(ExceptionCode.NOT_FOUND_DEVICE));

        return device;
    }

    public Measures findData(long deviceId){
        Measures measures = arduinoMeasuresRepository.findByDeviceId(deviceId)
                .orElseThrow(()-> new BusinessLogicException(ExceptionCode.NOT_FOUND_MEASURES));

        return measures;
    }

    // 해당 디바이스의 메타데이터 확인
    public ArduinoDto.GetResponseDto getData(long deviceId){

        return arduinoMapper.dtoToGetResponseDto(findDevice(deviceId),findData(deviceId));
    }

    // 디바이스 신규 등록
    public ArduinoDto.DeviceResponseDto postDevice(){
        Device device = new Device();
        device.setCreateAt(LocalDateTime.now());
        device = arduinoDeviceRepository.save(device);
        Measures measures = new Measures().builder().device(device).build();

        arduinoMeasuresRepository.save(measures);

        return arduinoMapper.deviceToDeviceResponseDto(device);
    }

    // 습도 저장
    public ArduinoDto.DataResponseDto updateHumidity(long deviceId,Long humidity){
        Measures measures = findData(deviceId);

        measures.setHumidity(measures.getHumidity());
        arduinoMeasuresRepository.save(measures);

        return arduinoMapper.measuresToDataResponseDto(measures);
    }

    // 기온 저장
    public ArduinoDto.DataResponseDto updateTemperature(long deviceId,Long temperature){
        Measures measures = findData(deviceId);

        measures.setTemperature(temperature);
        arduinoMeasuresRepository.save(measures);

        return arduinoMapper.measuresToDataResponseDto(measures);
    }


    // 토양 수분 저장
    public ArduinoDto.DataResponseDto updateSoilMoisture(long deviceId,Long soilMoisture){
        Measures measures = findData(deviceId);

        measures.setSoilMoisture(soilMoisture);
        arduinoMeasuresRepository.save(measures);

        return arduinoMapper.measuresToDataResponseDto(measures);
    }

    // 수위 저장
    public ArduinoDto.DataResponseDto updateWaterLevel(long deviceId,Long waterLevel){
        Measures measures = findData(deviceId);

        measures.setWaterLevel(waterLevel);
        arduinoMeasuresRepository.save(measures);

        return arduinoMapper.measuresToDataResponseDto(measures);
    }

    // 워터 펌프 동작
}
