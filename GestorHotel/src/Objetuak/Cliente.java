package Objetuak;

public class Cliente {
	
	
	private String dni;
	private String nombre;
	private String apellidos;
	private String direccion;
	private String localidad;
	
	public Cliente() {}
	
	public Cliente(String dni, String nombre, String apellidos, String direccion, String localidad) {
		this.dni = dni;
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.direccion=direccion;
		this.localidad=localidad;
	}
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	public String toString() {
		return "==============================================\r\n"
			 + "DNI: " + dni +"\r\n"
			 + "Nombre: " + nombre +"\r\n"
			 + "Apellidos: " + apellidos +"\r\n"
			 + "Direccion: " + direccion + "\r\n"
			 + "Localidad: " + localidad + "\r\n"
			 + "==============================================\r\n";
	}
	
}
