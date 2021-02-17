package Modelos;

import java.util.*;  
import java.util.Date;
import java.sql.*;

import Objetuak.Hoteles;
import Objetuak.Reservas;
import Conexion.*;

import org.joda.time.Interval;
import org.joda.time.base.*;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class ModeloReservas {
	
	Conector con = new Conector();
	
	public ArrayList<Reservas> listarReservas(){
		ArrayList<Reservas> reservaslist = new ArrayList<Reservas>();
		
		try {
			PreparedStatement ps = con.getConexion().prepareStatement("SELECT * FROM reservas");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				reservaslist.add(new Reservas(rs.getInt("id"), rs.getInt("id_habitaciones"),
						rs.getString("dni"), rs.getString("desde"), rs.getString("hasta")));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return reservaslist;
	}
	
	
	public ArrayList<Reservas> buscarReservas(String busqueda){
		ArrayList<Reservas> reservaslist = new ArrayList<Reservas>();
		
		try {
			PreparedStatement ps = con.getConexion().prepareStatement("SELECT * "
					+ "FROM reservas WHERE id LIKE ? OR id_habitaciones LIKE ? OR "
					+ "dni LIKE ? OR desde LIKE  ? OR hasta LIKE ?");
			
			ps.setString(1, "%" + busqueda + "%");
			ps.setString(2, "%" + busqueda + "%");
			ps.setString(3, "%" + busqueda + "%");
			ps.setString(4, "%" + busqueda + "%");
			ps.setString(5, "%" + busqueda + "%");

			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				reservaslist.add(new Reservas(rs.getInt("id"), rs.getInt("id_habitaciones"),
						rs.getString("dni"), rs.getString("desde"), rs.getString("hasta")));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		return reservaslist;
	}
	
	public boolean aniadirReserva(int id_habitacion, String dni, String desdeNuevo, String hastaNuevo, String desde, String hasta) {
		
		boolean done = false;
		
		if(seSolapan(desdeNuevo, hastaNuevo, desde, hasta)==true) {
			
		try {
			PreparedStatement ps = con.getConexion().prepareStatement("INSERT INTO hoteles "
					+ "(id_habitacion, dni. desde, hasta) VALUES (?, ?, ?, ?)");
			
			ps.setInt(1, id_habitacion);
			ps.setString(2, dni);
			ps.setString(3, hastaNuevo);
			ps.setString(4, desdeNuevo);
			
			ResultSet rs = ps.executeQuery();
			
			done = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		}
		return done;
	}
	
	public void eliminarReserva(int id) {
		
		try {
			PreparedStatement ps = con.getConexion().prepareStatement("DELETE FROM reservas WHERE id=?");
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean editarReserva (int id, int id_habitacion, String dni, String desdeNuevo, String hastaNuevo, String desde, String hasta) {
		
		boolean done = false;
		
		if (seSolapan(desdeNuevo, hastaNuevo, desde, hasta)==true) {
		try {
			PreparedStatement ps = con.getConexion().prepareStatement("UPDATE reservas SET id_habitacion=?, dni=?, "
					+ "desde=?, hasta=?  WHERE id=?");
			
			ps.setInt(1, id_habitacion);
			ps.setString(2, dni);
			ps.setString(3, desdeNuevo);
			ps.setString(4, hastaNuevo);
			ps.setInt(5, id);
			
			done = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		}
		return done;
	}
	
	public boolean seSolapan(String fechaInicio1, String fechaFin1, 
			String fechaInicio2, String fechaFin2) {
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
		
		boolean seSolapan;
		
		
		Interval intervalo1 = new Interval (formatter.parseDateTime(fechaInicio1), formatter.parseDateTime(fechaFin1));
		Interval intervalo2 = new Interval (formatter.parseDateTime(fechaInicio2), formatter.parseDateTime(fechaFin2));
		
		if(intervalo1.overlaps(intervalo2) ) {
			seSolapan = true;
		}
		else {
			seSolapan = false;
		}
		return seSolapan;
	}
}
