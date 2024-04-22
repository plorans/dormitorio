package com.um.dorm.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.um.dorm.Model.Cuarto;
import java.util.List;


@Repository
public interface CuartoDao extends JpaRepository<Cuarto,Long>{

    List<Cuarto> findByPasillo_Nombre(String pasillo);

    Cuarto findByNumero(Long numero);
    
}
