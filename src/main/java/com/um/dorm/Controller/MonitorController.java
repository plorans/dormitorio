package com.um.dorm.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.um.dorm.Manager.RoleManager;
import com.um.dorm.Manager.UsuarioManager;
import com.um.dorm.Model.Cuarto;
import com.um.dorm.Model.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/dormitorio")
@Slf4j
public class MonitorController {

    @Autowired
    private UsuarioManager usuarioManager;
    @Autowired
    private RoleManager roleManager;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/monitores")
    public ModelAndView getMonitores(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        ModelAndView mnv = new ModelAndView("monitores");
        HttpSession session = request.getSession();
        String nombre = (String) session.getAttribute("usuarioNombre");
        mnv.addObject("nombre", nombre);
        List<Usuario> usuarios = usuarioManager.getUsuarios("monitor");
        // log.info("monitores: " + usuarios);
        mnv.addObject("monitores", usuarios);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String usuario = auth.getName();
        String rol = "";

        if (auth != null && auth.isAuthenticated()) {
            for (GrantedAuthority authority : auth.getAuthorities()) {
                if (authority.getAuthority() != null) {
                    rol = authority.getAuthority();
                    // log.info("Rol del usuario autenticado: " + rol);
                }
            }
        }

        mnv.addObject("role", rol);

        return mnv;
    }

    @PostMapping("/monitores/save")
    public ModelAndView saveMonitor(Usuario usuario) {
        ModelAndView mnv = new ModelAndView();
        String passwordEncriptada = passwordEncoder.encode(usuario.getPassword());
        String roleTmp = usuario.getRoleTmp();
        usuario.setRole(roleManager.getRole(roleTmp));
        usuario.setPassword(passwordEncriptada);
        usuario.setMatricula(Integer.valueOf(usuario.getMatricula()));

        usuarioManager.saveUsuario(usuario);

        mnv.setViewName("redirect:/dormitorio/monitores");
        return mnv;
    }

    @PostMapping("/monitores/delete")
    public ModelAndView deleteCuarto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        ModelAndView mnv = new ModelAndView();

        Usuario delete = usuarioManager.getUsuarioById(Long.valueOf(id));

        usuarioManager.deleteUsuario(delete);

        mnv.setViewName("redirect:/dormitorio/monitores");
        return mnv;
    }

    @PostMapping("/monitores/edit")
    public ModelAndView editMonitor(Usuario usuario) {
        log.info("entor edit");
        ModelAndView mnv = new ModelAndView();

        usuario.setRole(roleManager.getRole(usuario.getRoleTmp()));
        usuarioManager.saveUsuario(usuario);
        mnv.setViewName("redirect:/dormitorio/monitores");
        return mnv;
    }
    
}
