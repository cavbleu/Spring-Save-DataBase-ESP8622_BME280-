package com.dmitiy.sensors.controller;

import com.dmitiy.sensors.entity.Sen_data;
import com.dmitiy.sensors.entity.Sensors;
import com.dmitiy.sensors.repositories.servises.ISensorService;
import com.dmitiy.sensors.repositories.servises.ISensorsDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
public class SensorController {

    @Autowired
    ISensorService iSensorService;

    @Autowired
    ISensorsDataService iSensorsDataService;

    @PostMapping("/saveDataSensor")
    public int saveDataSensor(@RequestBody Sen_data sen_data) {
        iSensorsDataService.saveSensorData(sen_data);
        return 200;
    }

    @PostMapping("/saveSensor")
    public int saveDataSensor(@RequestBody Sensors sensors) {
        iSensorService.saveSensors(sensors);
        return 200;
    }

    @GetMapping("/getDataSensor")
    public List<Sen_data> getAllSen_data() throws InterruptedException, ExecutionException {
        List<Sen_data> sen_data = new ArrayList<Sen_data>();
       sen_data = iSensorsDataService.getAllSensorData();
        return sen_data;
    }
}
