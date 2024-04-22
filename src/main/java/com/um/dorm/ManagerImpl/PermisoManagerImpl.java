package com.um.dorm.ManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.um.dorm.Dao.PermisoDao;
import com.um.dorm.Manager.PermisoManager;
import com.um.dorm.Model.Permiso;

@Service("PermisoManager")
public class PermisoManagerImpl implements PermisoManager {

    @Autowired
    private PermisoDao permisoDao;

    @Override
    public Permiso savePermiso(Permiso permiso) {
        return permisoDao.save(permiso);
    }

    @Override
    public void deletePermiso(Long id) {
        permisoDao.deleteById(id);
    }
    
}
