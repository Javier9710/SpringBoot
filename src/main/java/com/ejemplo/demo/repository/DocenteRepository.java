package com.ejemplo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplo.demo.entities.Docente;

public interface DocenteRepository extends JpaRepository<Docente, String> {

}
