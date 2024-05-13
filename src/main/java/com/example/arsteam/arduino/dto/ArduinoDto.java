package com.example.arsteam.arduino.dto;

import com.example.arsteam.arduino.entity.Device;
import com.example.arsteam.arduino.entity.Measures;
import lombok.*;

import java.time.LocalDateTime;


public class ArduinoDto {
    @Getter
    @Setter
    public static class DeviceResponseDto{
        private long deviceId;
        private LocalDateTime createAt;
    }
    @Getter
    @Setter
    public static class DataResponseDto{
        private long measureId;
        private long humidity;
        private long temperature;
        private long soilMoisture;
        private long waterLevel;
        private boolean waterPump;
        private boolean led;
        private boolean coolingFan;
    }

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    public static class GetResponseDto{
        private long deviceId;
        private long humidity;
        private long temperature;
        private long soilMoisture;
        private long waterLevel;
        private boolean waterPump ;
        private boolean led ;
        private boolean coolingFan ;
    }

}
