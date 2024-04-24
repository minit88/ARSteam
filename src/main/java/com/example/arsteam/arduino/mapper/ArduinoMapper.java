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

    default   ArduinoDto.GetResponseDto dtoToGetResponseDto(Device device , Measures measures){
        ArduinoDto.GetResponseDto responseDto = new ArduinoDto.GetResponseDto();

        responseDto.setDevice(device);
        responseDto.setMeasures(measures);

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

