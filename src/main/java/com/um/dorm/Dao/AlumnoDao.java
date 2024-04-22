package com.um.dorm.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.um.dorm.Model.Alumno;
import java.util.List;


@Repository
public interface AlumnoDao extends JpaRepository<Alumno,Long>{
    
    Alumno findByMatricula(String matricula);
}
