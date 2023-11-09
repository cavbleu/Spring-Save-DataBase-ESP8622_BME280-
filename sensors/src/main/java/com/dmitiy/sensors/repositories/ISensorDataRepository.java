package com.dmitiy.sensors.repositories;

import com.dmitiy.sensors.entity.Sen_data;
import com.dmitiy.sensors.entity.Sensors;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ISensorDataRepository extends JpaRepository<Sen_data,Long> {

    Optional<Sen_data> findById(Long id);
}
