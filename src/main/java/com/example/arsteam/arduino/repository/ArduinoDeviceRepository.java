package com.example.arsteam.arduino.repository;

import com.example.arsteam.arduino.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface ArduinoDeviceRepository extends JpaRepository<Device,String> {

    // 특정 디바이스 검색
    @Query("SELECT d FROM Device d WHERE d.deviceId = :deviceId")
    Optional<Device> findByDeviceId(@Param("deviceId") String deviceId);

}
