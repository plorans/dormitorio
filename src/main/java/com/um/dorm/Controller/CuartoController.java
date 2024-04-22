package com.um.dorm.Controller;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.um.dorm.Manager.AlumnoManager;
import com.um.dorm.Manager.CuartoManager;
import com.um.dorm.Manager.PasilloManager;
import com.um.dorm.Model.Cuarto;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/dormitorio")
@Slf4j
public class CuartoController {

    @Autowired
    private CuartoManager cuartoManager;

    @Autowired
    private AlumnoManager alumnoManager;

    @Autowired
    private PasilloManager pasilloManager;

    @GetMapping("/pasillo/{id}")
    public ModelAndView getCuartos(@PathVariable("id") String id, HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView mnv = new ModelAndView("cuartos");
        HttpSession session = request.getSession();
        String nombre = (String) session.getAttribute("usuarioNombre");
        mnv.addObject("nombre", nombre);
        try {
            List<Cuarto> listaCuarto = cuartoManager.getCuartos(id);

            Collections.sort(listaCuarto, new Comparator<Cuarto>() {
                @Override
                public int compare(Cuarto cuarto1, Cuarto cuarto2) {
                    return cuarto1.getNumero().compareTo(cuarto2.getNumero());
                }
            });

            mnv.addObject("listaCuarto", listaCuarto);
        } catch (Exception e) {
            // Manejar la excepción apropiadamente
        }
        mnv.addObject("pasillo", id);
        return mnv;
    }

    @PostMapping("/pasillo/cuarto")
    public ModelAndView editCuarto(Cuarto cuarto) {
        ModelAndView mnv = new ModelAndView();
        Cuarto salida = cuartoManager.getCuarto(cuarto.getId());
        salida.setPasillo(pasilloManager.getPasillo(cuarto.getPasilloTmp()));

        salida.setResidente1(alumnoManager.getAlumno(cuarto.getResidente1Tmp()));
        salida.setResidente2(alumnoManager.getAlumno(cuarto.getResidente2Tmp()));
        salida.setResidente3(alumnoManager.getAlumno(cuarto.getResidente3Tmp()));
        salida.setResidente4(alumnoManager.getAlumno(cuarto.getResidente4Tmp()));
        cuartoManager.saveCuarto(salida);

        mnv.setViewName("redirect:/dormitorio/pasillo/" + cuarto.getPasilloTmp());

        return mnv;
    }

    @PostMapping("/pasillo/cuarto/save")
    public ModelAndView saveCuarto(Cuarto cuarto) {

        ModelAndView mnv = new ModelAndView();
        cuarto.setResidente1(alumnoManager.getAlumno(cuarto.getResidente1Tmp()));
        cuarto.setResidente2(alumnoManager.getAlumno(cuarto.getResidente2Tmp()));
        cuarto.setResidente3(alumnoManager.getAlumno(cuarto.getResidente3Tmp()));
        cuarto.setResidente4(alumnoManager.getAlumno(cuarto.getResidente4Tmp()));
        cuarto.setPasillo(pasilloManager.getPasillo(String.valueOf(cuarto.getPasilloTmp().charAt(0))));

        cuartoManager.saveCuarto(cuarto);

        mnv.setViewName("redirect:/dormitorio/pasillo/" + cuarto.getPasilloTmp().charAt(0));

        return mnv;

    }

    @PostMapping("/pasillo/cuarto/delete")
    public ModelAndView deleteCuarto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.info("entro");

        String cuartoId = request.getParameter("cuartoId");
        ModelAndView mnv = new ModelAndView();

        Cuarto salida = cuartoManager.getCuarto(Long.valueOf(cuartoId));

        cuartoManager.deleteCuarto(salida.getId());

        mnv.setViewName("redirect:/dormitorio/pasillo/" + salida.getPasillo().getNombre());
        return mnv;
    }

}
