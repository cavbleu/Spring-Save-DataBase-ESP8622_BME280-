package com.dmitiy.sensors.repositories.servises;

import com.dmitiy.sensors.entity.Sen_data;
import com.dmitiy.sensors.entity.Sensors;

import java.util.List;
import java.util.Optional;

public interface ISensorsDataService {


    List<Sen_data> getAllSensorData();

    Optional<Sen_data> getSensorData(Long id_sens);

    Optional<Sen_data> findById_sen(Long id);

    void saveSensorData (Sen_data sen_data);
}
