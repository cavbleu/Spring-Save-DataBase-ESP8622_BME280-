package com.dmitiy.sensors.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.lang.annotation.Target;
import java.util.Date;

@Entity(name="sen_data")
@Setter
@Getter
@NoArgsConstructor
@Table(name="sen_data")
public class Sen_data {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idsen;

    private double temperature;
    private double humidity;
    private double pressure;
    private double co;
    private String datesend;
    private String timesend;


}
