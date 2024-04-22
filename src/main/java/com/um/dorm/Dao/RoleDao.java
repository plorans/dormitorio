package com.um.dorm.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.um.dorm.Model.Role;



@Repository
public interface RoleDao extends JpaRepository<Role,Long>{
    Role findByNombre(String nombre);
}
