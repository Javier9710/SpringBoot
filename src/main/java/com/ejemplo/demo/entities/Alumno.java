package com.ejemplo.demo.entities;


import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "alumno")
public class Alumno implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 101304718210149419L;
	@Id
	@Column(name = "codigo", nullable = false, length = 150)
	private String codigo;
	private String clave;
	private String email;
	private String nombre;
	@ManyToOne
	@JoinColumn(name="materia")
	private Materia materia;

public Alumno() {
		
		
		
		
	}
	
	
	




	public Alumno(String codigo, String clave, String email, String nombre,Materia materia) {
	super();
	this.codigo = codigo;
	this.clave = clave;
	this.email = email;
	this.nombre = nombre;
	this.materia = materia;
}







	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getClave() {
		return clave;
	}


	public void setClave(String clave) {
		this.clave = clave;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Materia getMateria() {
		return materia;
	}



	public void setMateria(Materia materia) {
		this.materia = materia;
	}








	

}


