package com.spring.demo00.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.demo00.entity.Alumno;
import com.spring.demo00.service.AlumnoService;

// Controlador MVC que gestiona las peticiones HTTP de Alumno
@Controller
@RequestMapping("/alumnos")
public class AlumnoController {

    // Inyeccion de dependencia sobre la instancia (no en constructor)
    @Autowired
    private AlumnoService alumnoService;

    // GET /alumnos - Muestra la lista de todos los alumnos
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("alumnos", alumnoService.listarTodos());
        return "alumnos-list";
    }

    // GET /alumnos/nuevo - Muestra el formulario para crear un alumno
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("alumno", new Alumno());
        return "alumno-form";
    }

    // GET /alumnos/{id}/editar - Muestra el formulario con los datos del alumno
    @GetMapping("/{id}/editar")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        model.addAttribute("alumno", alumnoService.buscarPorId(id));
        return "alumno-form";
    }

    // POST /alumnos - Guarda un alumno nuevo o actualiza uno existente
    @PostMapping
    public String guardar(@ModelAttribute("alumno") Alumno alumno,
                          BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "alumno-form";
        }
        alumnoService.guardar(alumno);
        return "redirect:/alumnos";
    }

    // POST /alumnos/{id}/eliminar - Elimina el alumno con el id indicado
    @PostMapping("/{id}/eliminar")
    public String eliminar(@PathVariable Long id) {
        alumnoService.eliminar(id);
        return "redirect:/alumnos";
    }
}