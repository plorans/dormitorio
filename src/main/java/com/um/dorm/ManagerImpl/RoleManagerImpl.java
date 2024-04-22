package com.um.dorm.ManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.um.dorm.Dao.RoleDao;
import com.um.dorm.Manager.RoleManager;
import com.um.dorm.Model.Role;

@Service("RoleManager")
public class RoleManagerImpl implements RoleManager {
    
    @Autowired
    private RoleDao roleDao;

    @Override
    public Role getRole(String nombre) {
        return roleDao.findByNombre(nombre);
    }
}
