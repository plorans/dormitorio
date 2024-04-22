package com.um.dorm.ManagerImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.um.dorm.Dao.AlumnoDao;
import com.um.dorm.Manager.AlumnoManager;
import com.um.dorm.Model.Alumno;

@Service("AlumnoManager")
public class AlumnoManagerImpl implements AlumnoManager{

    @Autowired
    private AlumnoDao alumnoDao;

    @Override
    public List<Alumno> getAlumnos() {
        return alumnoDao.findAll();
    }

    @Override
    public Alumno getAlumno(String matricula) {
        return alumnoDao.findByMatricula(matricula);
    }

    @Override
    public Alumno saveAlumno(Alumno alumno) {
        return alumnoDao.save(alumno);
    }

    @Override
    public void deleteAlumno(Long id) {
     alumnoDao.deleteById(id);
    }
    
}
