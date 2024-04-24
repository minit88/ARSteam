package com.example.arsteam.arduino.repository;

import com.example.arsteam.arduino.entity.Measures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface ArduinoMeasuresRepository extends JpaRepository<Measures, Long> {

    // 특정 디바이스의 측정값 검색
    @Query("SELECT m From Measures m WHERE m.device.deviceId = :deviceId")
    Optional<Measures> findByDeviceId(@Param("deviceId") String deviceId);
}
