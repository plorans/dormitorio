package com.um.dorm.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "pasillo")
public class Pasillo {
    
    @Id
    private Long id;

    private String nombre;

    private String monitor;

    private String asistente;
    
}
