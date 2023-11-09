package com.dmitiy.sensors.repositories.servises;

import com.dmitiy.sensors.entity.Sensors;
import com.dmitiy.sensors.repositories.ISensorDataRepository;
import com.dmitiy.sensors.repositories.ISensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SensorService implements ISensorService{



    @Autowired
    private ISensorRepository iSensorRepository;

    private List<Sensors> sensorsList;

    @Override
    public List<Sensors> getAllSensors() {
        return iSensorRepository.findAll();
    }

    @Override
    public Optional<Sensors> findById(Long id) {
        return iSensorRepository.findById(id);
    }

    @Override
    public void saveSensors(Sensors sensors) {
        iSensorRepository.save(sensors);
    }

    @Override
    public void deleteSensor(Long id) {
        iSensorRepository.deleteById(id);
    }
}
