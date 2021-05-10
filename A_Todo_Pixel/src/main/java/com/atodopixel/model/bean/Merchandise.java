package com.atodopixel.model.bean;

public class Merchandise extends Producto {
	private int codigo_tipo;

	public Merchandise(int codigo_producto, String nombre, String descripcion, double precio, String img1, String img2,
			String img3, int like, boolean eliminado, int codigo_tipo) {
		super(codigo_producto, nombre, descripcion, precio, img1, img2, img3, like, eliminado);
		this.codigo_tipo = codigo_tipo;
	}

	public int getCodigo_tipo() {
		return codigo_tipo;
	}

	public void setCodigo_tipo(int codigo_tipo) {
		this.codigo_tipo = codigo_tipo;
	}

	@Override
	public String toString() {
		return "Merchandise [codigo_tipo=" + codigo_tipo + ", codigo_producto=" + codigo_producto + ", nombre=" + nombre
				+ ", descripcion=" + descripcion + ", precio=" + precio + ", img1=" + img1 + ", img2=" + img2
				+ ", img3=" + img3 + ", like=" + like + ", eliminado=" + eliminado + "]";
	}
	
	
	
}
