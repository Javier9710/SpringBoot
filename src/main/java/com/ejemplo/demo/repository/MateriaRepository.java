package com.ejemplo.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplo.demo.entities.Materia;

public interface MateriaRepository extends JpaRepository<Materia, Integer> {

}
