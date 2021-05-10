package com.atodopixel.model.bean;

public class Consola extends Producto{
	private int generacion;
	private int codigo_compania;
	
	public Consola(int codigo_producto, String nombre, String descripcion, double precio, String img1, String img2,
			String img3, int like, boolean eliminado, int generacion, int codigo_compania) {
		super(codigo_producto, nombre, descripcion, precio, img1, img2, img3, like, eliminado);
		this.generacion = generacion;
		this.codigo_compania = codigo_compania;
	}
	public int getGeneracion() {
		return generacion;
	}
	public void setGeneracion(int generacion) {
		this.generacion = generacion;
	}
	public int getCodigo_compania() {
		return codigo_compania;
	}
	public void setCodigo_compania(int codigo_compania) {
		this.codigo_compania = codigo_compania;
	}
	@Override
	public String toString() {
		return "Consola [generacion=" + generacion + ", codigo_compania=" + codigo_compania + ", codigo_producto="
				+ codigo_producto + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio
				+ ", img1=" + img1 + ", img2=" + img2 + ", img3=" + img3 + ", like=" + like + ", eliminado=" + eliminado
				+ "]";
	}
	
	
}
