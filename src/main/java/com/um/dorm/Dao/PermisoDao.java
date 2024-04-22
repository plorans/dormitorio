package com.um.dorm.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.um.dorm.Model.Permiso;

@Repository
public interface PermisoDao extends JpaRepository<Permiso,Long>{
    
   
}
