package com.um.dorm.ManagerImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.um.dorm.Dao.CuartoDao;
import com.um.dorm.Manager.CuartoManager;
import com.um.dorm.Model.Cuarto;

@Service("cuartoManager")
public class CuartoManagerImpl implements CuartoManager{

   @Autowired
   private CuartoDao cuartoDao; 

    @Override
    public List<Cuarto> getCuartos(String pasillo) {
        List<Cuarto> cuartos = cuartoDao.findByPasillo_Nombre(pasillo);
        return cuartos;
    }

    @Override
    public Cuarto saveCuarto(Cuarto cuarto) {
        return cuartoDao.save(cuarto);
    }

    @Override
    public void deleteCuarto(Long id) {
        cuartoDao.deleteById(id);
    }

    @Override
    public Cuarto getCuarto(Long id) {
        return cuartoDao.findById(id).orElseThrow();
    }

    @Override
    public Cuarto getCuartoByNumero(Long numero) {
        return cuartoDao.findByNumero(numero);
    }
    
}
