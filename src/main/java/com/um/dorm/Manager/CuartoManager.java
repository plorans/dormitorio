package com.um.dorm.Manager;

import java.util.List;

import com.um.dorm.Model.Cuarto;

public interface CuartoManager {
    
    List<Cuarto> getCuartos(String pasillo);

    Cuarto getCuarto(Long id);

    Cuarto getCuartoByNumero(Long numero);

    Cuarto saveCuarto(Cuarto cuarto);

    void deleteCuarto(Long id);
}
