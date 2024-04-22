package com.um.dorm.Manager;

import java.util.List;

import com.um.dorm.Model.Usuario;

public interface UsuarioManager {
    
    Usuario getUsuario(String usuario);

    List<Usuario> getUsuarios(String role);

    Usuario saveUsuario(Usuario usuario);

    Usuario getUsuarioById(Long id);

    void deleteUsuario(Usuario usuario);
}
