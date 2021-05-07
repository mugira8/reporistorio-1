package com.example.demo.bean;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

	private int id;
	private String nombreApellido;
	private String dni;
	private String codigo;
	
	private List<Inscripcion> inscripciones;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreApellido() {
		return nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public List<Inscripcion> getInscripciones() {
		return inscripciones;
	}

	public void setInscripciones(List<Inscripcion> inscripciones) {
		this.inscripciones = inscripciones;
	}
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombreApellido=" + nombreApellido + ", dni=" + dni + ", codigo=" + codigo + "]";
	}
}
