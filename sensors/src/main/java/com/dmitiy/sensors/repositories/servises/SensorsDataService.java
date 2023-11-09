package com.dmitiy.sensors.repositories.servises;

import com.dmitiy.sensors.entity.Sen_data;
import com.dmitiy.sensors.repositories.ISensorDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;


@Service
public class SensorsDataService implements ISensorsDataService{

    private final SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd");
    private final SimpleDateFormat formatForTimeNow = new SimpleDateFormat("k:mm:ss");
    @Autowired
    private ISensorDataRepository iSensorDataRepository;

    private List<Sen_data> sen_dataList;

    @Override
    public List<Sen_data> getAllSensorData() {
        return iSensorDataRepository.findAll();
    }

    @Override
    public Optional<Sen_data> getSensorData(Long id_sens) {
        return iSensorDataRepository.findById(id_sens);
    }

    @Override
    public Optional<Sen_data> findById_sen(Long id) {
        return iSensorDataRepository.findById(id);
    }

    @Override
    public void saveSensorData(Sen_data sen_data) {
        Date dateNow = new Date();
        sen_data.setDatesend(formatForDateNow.format(dateNow));
        sen_data.setTimesend(formatForTimeNow.format(dateNow));
        iSensorDataRepository.save(sen_data);
    }
}
