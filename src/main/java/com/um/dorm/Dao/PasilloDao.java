package com.um.dorm.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.um.dorm.Model.Pasillo;


@Repository
public interface PasilloDao extends JpaRepository<Pasillo,Long>{

    Pasillo findByNombre(String nombre);
    
}
