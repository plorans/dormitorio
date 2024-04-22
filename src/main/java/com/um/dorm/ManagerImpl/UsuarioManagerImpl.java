package com.um.dorm.ManagerImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.um.dorm.Dao.RoleDao;
import com.um.dorm.Dao.UsuarioDao;
import com.um.dorm.Manager.RoleManager;
import com.um.dorm.Manager.UsuarioManager;
import com.um.dorm.Model.Role;
import com.um.dorm.Model.Usuario;

import lombok.extern.slf4j.Slf4j;

@Service("UsuarioManager")
@Slf4j
public class UsuarioManagerImpl implements UsuarioManager{

    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private RoleManager roleManager;

    @Override
    public Usuario getUsuario(String usuario) {
        return usuarioDao.findByUsername(usuario);
    }

    @Override
    public List<Usuario> getUsuarios(String role) {
        // log.info("Entra manager " + role);

        Role id = roleManager.getRole(role);

        List<Usuario> salida = usuarioDao.findByRole_Id(id.getId());
        // log.info("salida " + salida);
        return salida;
    }

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        return usuarioDao.save(usuario);
    }

    @Override
    public Usuario getUsuarioById(Long id) {
        return usuarioDao.findById(id).orElseThrow();
    }

    @Override
    public void deleteUsuario(Usuario usuario) {
        usuarioDao.delete(usuario);
    }
    
}
