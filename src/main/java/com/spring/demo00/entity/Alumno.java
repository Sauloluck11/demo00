package com.spring.demo00.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Entidad JPA que mapea la tabla "alumnos" de MySQL
@Entity
@Table(name = "alumnos")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nombre obligatorio, maximo 50 caracteres
    @Column(nullable = false, length = 50)
    private String nombre;

    // Apellidos obligatorios, maximo 100 caracteres
    @Column(nullable = false, length = 100)
    private String apellidos;

    // Email unico en la tabla
    @Column(length = 100, unique = true)
    private String email;

    // Curso del alumno
    @Column(length = 50)
    private String curso;

    // Constructor vacio requerido por JPA
    public Alumno() {
        super();
    }

    // Constructor con todos los campos
    public Alumno(String nombre, String apellidos, String email, String curso) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.curso = curso;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }
}