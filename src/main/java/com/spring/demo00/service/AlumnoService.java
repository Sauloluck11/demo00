package com.spring.demo00.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.demo00.entity.Alumno;
import com.spring.demo00.repository.AlumnoRepository;

// Servicio que contiene la logica de negocio de Alumno
@Service
public class AlumnoService {

    // Inyeccion de dependencia sobre la instancia (no en constructor)
    @Autowired
    private AlumnoRepository alumnoRepository;

    // Devuelve la lista de todos los alumnos
    public List<Alumno> listarTodos() {
        return alumnoRepository.findAll();
    }

    // Busca un alumno por su id, lanza excepcion si no existe
    public Alumno buscarPorId(Long id) {
        return alumnoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Alumno no encontrado: " + id));
    }

    // Guarda un alumno nuevo o actualiza uno existente
    public Alumno guardar(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    // Elimina el alumno con el id indicado
    public void eliminar(Long id) {
        alumnoRepository.deleteById(id);
    }
}