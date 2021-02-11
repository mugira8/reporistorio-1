package Objetuak;
import java.util.*;
public class Reservas {
	
	private int id;
	private int id_habitacion;
	private String dni;
	private String desde;
	private String hasta;
	
	public Reservas() {}
	
	public Reservas(int id, int id_habitacion, String dni, String desde, String hasta) {
		this.id=id;
		this.id_habitacion=id_habitacion;
		this.dni=dni;
		this.desde=desde;
		this.hasta=hasta;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_habitacion() {
		return id_habitacion;
	}
	public void setId_habitacion(int id_habitacion) {
		this.id_habitacion = id_habitacion;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getDesde() {
		return desde;
	}
	public void setDesde(String desde) {
		this.desde = desde;
	}
	public String getHasta() {
		return hasta;
	}
	public void setHasta(String hasta) {
		this.hasta = hasta;
	}
	
	public String toString() {
		return "==============================================\r\n"
			 + "ID: " + id +"\r\n"
			 + "ID de la habitacion: " + id_habitacion +"\r\n"
			 + "DNI: " + dni +"\r\n"
			 + "Fecha de inicio: " + desde + "\r\n"
			 + "Fecha de salida: " + hasta + "\r\n"
			 + "==============================================\r\n";
	}
}
