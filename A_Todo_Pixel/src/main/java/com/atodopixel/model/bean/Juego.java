package com.atodopixel.model.bean;

public class Juego extends Producto {
	private int pegi;
	private int codigo_compania;
	
	public Juego(int codigo_producto, String nombre, String descripcion, double precio, String img1, String img2,
			String img3, int like, boolean eliminado, int pegi, int codigo_compania) {
		super(codigo_producto, nombre, descripcion, precio, img1, img2, img3, like, eliminado);
		this.pegi = pegi;
		this.codigo_compania = codigo_compania;
	}

	public int getPegi() {
		return pegi;
	}

	public void setPegi(int pegi) {
		this.pegi = pegi;
	}

	public int getCodigo_compania() {
		return codigo_compania;
	}

	public void setCodigo_compania(int codigo_compania) {
		this.codigo_compania = codigo_compania;
	}

	@Override
	public String toString() {
		return "Juego [pegi=" + pegi + ", codigo_compania=" + codigo_compania + ", codigo_producto=" + codigo_producto
				+ ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", img1=" + img1
				+ ", img2=" + img2 + ", img3=" + img3 + ", like=" + like + ", eliminado=" + eliminado + "]";
	}	
	
}
