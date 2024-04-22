package com.um.dorm.Model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
@Table(name = "cuarto")
public class Cuarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero", unique = true, nullable = false)
    private Long numero;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "residente1", referencedColumnName = "matricula")
    private Alumno residente1;

    @Transient
    private String residente1Tmp;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "residente2", referencedColumnName = "matricula")
    private Alumno residente2;

    @Transient
    private String residente2Tmp;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "residente3", referencedColumnName = "matricula")
    private Alumno residente3;

    @Transient
    private String residente3Tmp;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "residente4", referencedColumnName = "matricula")
    private Alumno residente4;

    @Transient
    private String residente4Tmp;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pasillo_id")
    private Pasillo pasillo;

    @Transient
    private String pasilloTmp;

}
