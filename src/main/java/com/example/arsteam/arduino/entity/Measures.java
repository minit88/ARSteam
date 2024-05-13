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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long measureId;
    private long humidity;
    private long temperature;
    private long soilMoisture;
    private long waterLevel;
    private boolean waterPump ;
    private boolean led ;
    private boolean coolingFan ;


    public boolean isLed(){
        return led;
    }

    public boolean isWaterPump(){
        return waterPump;
    }

    public boolean isCoolingFan(){
        return coolingFan;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_id")
    private Device device;
}
