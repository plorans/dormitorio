package com.um.dorm.Security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.um.dorm.Dao.UsuarioDao;
import com.um.dorm.Model.Usuario;

@Service
public class UserDetail implements UserDetailsService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {

        Usuario user = usuarioDao.findByUsername(usuario);
        if (user == null) {
            new UsernameNotFoundException("User not exists by Username");
        }
        Set<GrantedAuthority> authorities = new HashSet<>();
        if (user.getRole() != null && !user.getRole().getNombre().isEmpty()) {
            authorities.add(new SimpleGrantedAuthority(user.getRole().getNombre()));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                authorities);

    }

}
