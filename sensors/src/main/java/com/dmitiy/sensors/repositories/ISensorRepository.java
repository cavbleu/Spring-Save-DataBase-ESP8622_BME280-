package com.dmitiy.sensors.repositories;

import com.dmitiy.sensors.entity.Sensors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ISensorRepository extends JpaRepository<Sensors,Long> {
    Optional<Sensors> findById(Long id);

}
