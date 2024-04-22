package com.um.dorm.Model;

import java.sql.Date;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "permisos")
public class Permiso {

    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "alumno", nullable = false)
    private Alumno alumno;

    @Column(nullable = false)
    private String lugar;

    @Column(name = "hora_salida", nullable = false)
    private Date salida;

    @Column(name = "hora_entrada", nullable = false)
    private Date entrada;

    private Boolean aceptado;

}
