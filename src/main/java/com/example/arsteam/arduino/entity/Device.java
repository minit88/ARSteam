package com.example.arsteam.arduino.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Setter
@Getter
@Entity
public class Device {

    @Id
    private String deviceId;
    private LocalDateTime createAt;


    @OneToOne
    @JoinColumn(name = "measureId")
    Measures measures ;
}
