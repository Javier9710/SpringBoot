package com.ejemplo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplo.demo.entities.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, String> {

}
