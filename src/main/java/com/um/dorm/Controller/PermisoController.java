package com.um.dorm.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.um.dorm.Manager.PermisoManager;
import com.um.dorm.Model.Permiso;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("/dormitorio")
public class PermisoController {

    @Autowired
    private PermisoManager permisoManager;

    @PostMapping("/permiso/guardar")
    public ModelAndView savePermiso(Permiso permiso) {
        ModelAndView mnv = new ModelAndView();
        permisoManager.savePermiso(permiso);
        
        return mnv;
    }
    
    
    
}
