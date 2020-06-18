package com.ejemplo.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="docente")
public class Docente implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "cedula", nullable = false, length = 150)
	private String cedula;
	private String nombre;
	
	
	public Docente() {
		
	}
	
	public Docente(String cedula, String nombre) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
	}
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
