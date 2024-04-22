package com.um.dorm.Manager;

import com.um.dorm.Model.Permiso;

public interface PermisoManager {
    
    Permiso savePermiso(Permiso permiso);

    void deletePermiso(Long id);
}
