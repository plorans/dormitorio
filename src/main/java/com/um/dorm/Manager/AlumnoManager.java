package com.um.dorm.Manager;

import java.util.List;

import com.um.dorm.Model.Alumno;

public interface AlumnoManager {
    
    List<Alumno> getAlumnos();

    Alumno getAlumno(String matricula);

    Alumno saveAlumno(Alumno alumno);

    void deleteAlumno(Long id);
}
