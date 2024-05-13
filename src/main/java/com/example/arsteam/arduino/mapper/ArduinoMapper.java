package com.example.arsteam.arduino.mapper;


import com.example.arsteam.arduino.dto.ArduinoDto;
import com.example.arsteam.arduino.entity.Device;
import com.example.arsteam.arduino.entity.Measures;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public interface ArduinoMapper {


    default ArduinoDto.DeviceResponseDto deviceToDeviceResponseDto(Device device){
        ArduinoDto.DeviceResponseDto deviceResponseDto = new ArduinoDto.DeviceResponseDto();

        deviceResponseDto.setDeviceId(device.getDeviceId());
        deviceResponseDto.setCreateAt(device.getCreateAt());

        return deviceResponseDto;
    }

    default   ArduinoDto.GetResponseDto dtoToGetResponseDto(Device device){
        Measures measures = device.getMeasures();
        ArduinoDto.GetResponseDto responseDto = ArduinoDto.GetResponseDto.builder()
                .deviceId(device.getDeviceId())
                .humidity(measures.getHumidity())
                .temperature(measures.getTemperature())
                .soilMoisture(measures.getSoilMoisture())
                .waterLevel(measures.getWaterLevel())
                .waterPump(measures.isWaterPump())
                .led(measures.isLed())
                .coolingFan(measures.isCoolingFan())
                .build();

        return responseDto;
    }
    default   ArduinoDto.GetResponseDto dtoToGetResponseDto(long deviceId,Measures measures){

        ArduinoDto.GetResponseDto responseDto = ArduinoDto.GetResponseDto.builder()
                .deviceId(deviceId)
                .humidity(measures.getHumidity())
                .temperature(measures.getTemperature())
                .soilMoisture(measures.getSoilMoisture())
                .waterLevel(measures.getWaterLevel())
                .waterPump(measures.isWaterPump())
                .led(measures.isLed())
                .coolingFan(measures.isCoolingFan())
                .build();

        return responseDto;
    }

    default ArduinoDto.DataResponseDto measuresToDataResponseDto(Measures measures){
        ArduinoDto.DataResponseDto responseDto = new ArduinoDto.DataResponseDto();

        responseDto.setMeasureId(measures.getMeasureId());
        responseDto.setHumidity(measures.getHumidity());
        responseDto.setLed(measures.isLed());
        responseDto.setTemperature(measures.getTemperature());
        responseDto.setCoolingFan(measures.isCoolingFan());
        responseDto.setSoilMoisture(measures.getSoilMoisture());
        responseDto.setWaterLevel(measures.getWaterLevel());
        responseDto.setWaterPump(measures.isWaterPump());

        return responseDto;
    }
}

