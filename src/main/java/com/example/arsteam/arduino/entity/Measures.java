package com.example.arsteam.arduino.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.lang.Nullable;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Measures {

    @Id
    private long measureId;
    private long humidity;
    private long temperature;
    private long soilMoisture;
    private long waterLevel;
    private boolean waterPump ;
    private boolean led ;
    private boolean coolingFan ;

    @OneToOne
    @JoinColumn(name = "deviceId")
    Device device;


    public boolean isLed(){
        return led;
    }

    public boolean isWaterPump(){
        return waterPump;
    }

    public boolean isCoolingFan(){
        return coolingFan;
    }
}
