package com.spring.demo00.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.demo00.entity.Alumno;

// Repositorio JPA para Alumno: hereda los metodos CRUD de JpaRepository
@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
    // Spring Data JPA genera automaticamente findAll, findById, save, deleteById
}