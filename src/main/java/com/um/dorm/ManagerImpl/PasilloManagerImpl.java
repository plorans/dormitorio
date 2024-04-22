package com.um.dorm.ManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.um.dorm.Dao.PasilloDao;
import com.um.dorm.Manager.PasilloManager;
import com.um.dorm.Model.Pasillo;

@Service("PasilloManager")
public class PasilloManagerImpl implements PasilloManager{

    @Autowired
    private PasilloDao pasilloDao;

    @Override
    public Pasillo getPasillo(String nombre) {
        return pasilloDao.findByNombre(nombre);
    }
    
}
