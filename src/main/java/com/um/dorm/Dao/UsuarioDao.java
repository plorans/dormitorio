package com.um.dorm.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.um.dorm.Model.Usuario;
import java.util.List;


public interface UsuarioDao extends JpaRepository<Usuario,Long>{
    
    Usuario findByUsername(String username);

    List<Usuario> findByRole_Id(Long roleId);
}


