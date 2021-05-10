package com.atodopixel.model.bean;

public class Producto {
		protected int codigo_producto;
		protected String nombre;
		protected String descripcion;
		protected double precio;
		protected String img1;
		protected String img2;
		protected String img3;
		protected int like;
		protected boolean eliminado;
		
		public Producto(int codigo_producto, String nombre, String descripcion, double precio, String img1, String img2,
				String img3, int like, boolean eliminado) {
			super();
			this.codigo_producto = codigo_producto;
			this.nombre = nombre;
			this.descripcion = descripcion;
			this.precio = precio;
			this.img1 = img1;
			this.img2 = img2;
			this.img3 = img3;
			this.like = like;
			this.eliminado = eliminado;
		}
		public int getCodigo_producto() {
			return codigo_producto;
		}
		public void setCodigo_producto(int codigo_producto) {
			this.codigo_producto = codigo_producto;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
		public double getPrecio() {
			return precio;
		}
		public void setPrecio(double precio) {
			this.precio = precio;
		}
		public String getImg1() {
			return img1;
		}
		public void setImg1(String img1) {
			this.img1 = img1;
		}
		public String getImg2() {
			return img2;
		}
		public void setImg2(String img2) {
			this.img2 = img2;
		}
		public String getImg3() {
			return img3;
		}
		public void setImg3(String img3) {
			this.img3 = img3;
		}
		public int getLike() {
			return like;
		}
		public void setLike(int like) {
			this.like = like;
		}
		public boolean isEliminado() {
			return eliminado;
		}
		public void setEliminado(boolean eliminado) {
			this.eliminado = eliminado;
		}
		@Override
		public String toString() {
			return "Producto [codigo_producto=" + codigo_producto + ", nombre=" + nombre + ", descripcion="
					+ descripcion + ", precio=" + precio + ", img1=" + img1 + ", img2=" + img2 + ", img3=" + img3
					+ ", like=" + like + ", eliminado=" + eliminado + "]";
		}
		
}
