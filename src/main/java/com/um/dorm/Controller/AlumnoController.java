package com.um.dorm.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.um.dorm.Manager.AlumnoManager;
import com.um.dorm.Model.Alumno;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/dormitorio")
public class AlumnoController {

    @Autowired
    private AlumnoManager alumnoManager;

    @GetMapping("/alumnos")
    public ModelAndView getAlumnos(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        ModelAndView mnv = new ModelAndView("alumnos");
        HttpSession session = request.getSession();
        String nombre = (String) session.getAttribute("usuarioNombre");
        mnv.addObject("nombre", nombre);

        mnv.addObject("alumnos", alumnoManager.getAlumnos());

        return mnv;
    }

    @PostMapping("alumnos/save")
    public ModelAndView saveAlumno(Alumno alumno) {
        ModelAndView mnv = new ModelAndView();
        
        alumnoManager.saveAlumno(alumno);
        mnv.setViewName("redirect:/dormitorio/alumnos");
        return mnv;
    }

    @PostMapping("/alumnos/edit")
    public ModelAndView editAlumno(Alumno alumno) {
        ModelAndView mnv = new ModelAndView();
        alumnoManager.saveAlumno(alumno);
        mnv.setViewName("redirect:/dormitorio/alumnos");

        return mnv;
    }

    @PostMapping("/alumnos/delete")
    public ModelAndView postMethodName(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        ModelAndView mnv = new ModelAndView();
        
        String id = request.getParameter("id");

        alumnoManager.deleteAlumno(Long.valueOf(id));
        mnv.setViewName("redirect:/dormitorio/alumnos");

        return mnv;
    }
    
    
    
    
    
}
