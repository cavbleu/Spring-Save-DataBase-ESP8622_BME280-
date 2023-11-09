package com.dmitiy.sensors.repositories.servises;

import com.dmitiy.sensors.entity.Sensors;

import java.util.List;
import java.util.Optional;

public interface ISensorService {

    List<Sensors> getAllSensors();

    Optional<Sensors> findById(Long id);

    void saveSensors (Sensors sensors);

    void deleteSensor (Long id);
}
