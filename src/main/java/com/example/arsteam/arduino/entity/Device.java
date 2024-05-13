package com.example.arsteam.arduino.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Setter
@Getter
@Entity
public class Device {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long deviceId;
    private LocalDateTime createAt;


    @OneToOne(mappedBy = "device", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Measures measures ;
}
