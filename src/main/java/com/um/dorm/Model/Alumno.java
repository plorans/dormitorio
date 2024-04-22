package com.um.dorm.Model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "alumnos")
public class Alumno implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alumnos_id_seq")
    @SequenceGenerator(name = "alumnos_id_seq", sequenceName = "alumnos_id_seq", allocationSize = 1)
    private Long id;

    private String matricula;

    private String nombre;

    private String cuarto;
}
