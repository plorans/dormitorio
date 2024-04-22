package com.um.dorm.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.um.dorm.Dao.UsuarioDao;
import com.um.dorm.Manager.AlumnoManager;
import com.um.dorm.Manager.UsuarioManager;
import com.um.dorm.Model.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/dormitorio")
public class InicioController {

    @Autowired
    private UsuarioManager usuarioManager;

    @Autowired
    private AlumnoManager alumnoManager;

    @GetMapping(value = "/inicio")
    private ModelAndView inicio(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView mnv = new ModelAndView();
        HttpSession session = request.getSession();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String usuario = auth.getName();
        String nombre = usuarioManager.getUsuario(usuario).getNombre();
        
        session.setAttribute("usuarioNombre", nombre);
        mnv.addObject("nombre", nombre);
        mnv.setViewName("index");
        mnv.addObject("alumnos", alumnoManager.getAlumnos());

        return mnv;
    }
}
