package com.example.demo.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Actividad {
	private int id;
	private String nombre;
	private Date fecha_inicio;
	private String dias;
	private int horas;
	private int maxParticipantes;
	private double precio;
	
	private List<Inscripcion> iscripciones;
	
	public Actividad(int id, String nombre, Date fecha_inicio, String dias, int horas, int maxParticipantes,
			double precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fecha_inicio = fecha_inicio;
		this.dias = dias;
		this.horas = horas;
		this.maxParticipantes = maxParticipantes;
		this.precio = precio;
	}
	public Actividad() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public String getDias() {
		return dias;
	}
	public void setDias(String dias) {
		this.dias = dias;
	}
	public int getHoras() {
		return horas;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}
	public int getMaxParticipantes() {
		return maxParticipantes;
	}
	public void setMaxParticipantes(int maxParticipantes) {
		this.maxParticipantes = maxParticipantes;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public List<Inscripcion> getIscripciones() {
		return iscripciones;
	}
	public void setIscripciones(List<Inscripcion> iscripciones) {
		this.iscripciones = iscripciones;
	}
	
	@Override
	public String toString() {
		return "Actividad [id=" + id + ", nombre=" + nombre + ", fecha_inicio=" + fecha_inicio + ", dias=" + dias
				+ ", horas=" + horas + ", maxParticipantes=" + maxParticipantes + ", precio=" + precio + "]";
	}
	

	
}
