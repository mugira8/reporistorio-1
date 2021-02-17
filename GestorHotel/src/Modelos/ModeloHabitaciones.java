package Modelos;

import java.sql.*;
import java.util.*;

import Conexion.*;
import Objetuak.*;
public class ModeloHabitaciones {

	Conector con = new Conector();
	
	public ArrayList<Habitaciones> listarHabitaciones(){
		
		ArrayList<Habitaciones> habitacioneslist = new ArrayList<Habitaciones>();
		
		try {
			PreparedStatement ps = con.getConexion().prepareStatement("SELECT * FROM habitaciones");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				habitacioneslist.add(new Habitaciones (rs.getInt("id"),
						rs.getInt("id_hotel"), rs.getString("numero"), 
						rs.getString("descripcion"), rs.getDouble("precio")));
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return habitacioneslist;
	}
	
	public ArrayList<Habitaciones> buscarHabitaciones(String busqueda){
		
		ArrayList<Habitaciones> habitacioneslist = new ArrayList<Habitaciones>();
		
		try {
			PreparedStatement ps = con.getConexion().prepareStatement("SELECT * FROM habitaciones WHERE"
					+ "id LIKE ? OR id_hotel LIKE ? OR numero LIKE ? OR descripcion LIKE ?"
					+ "OR precio LIKE ?");
			
			ps.setString(1, busqueda);
			ps.setString(2, busqueda);
			ps.setString(3, busqueda);
			ps.setString(4, busqueda);
			ps.setString(5, busqueda);

			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				habitacioneslist.add(new Habitaciones (rs.getInt("id"),
						rs.getInt("id_hotel"), rs.getString("numero"), 
						rs.getString("descripcion"), rs.getDouble("precio")));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return habitacioneslist;
	}
	
	public void aniadirHabitacion(int id_hotel, String numero, String descripcion, double precio) {
		
		try {
			PreparedStatement ps = con.getConexion().prepareStatement("INSERT INTO habitaciones "
					+ "(id_hotel, numero, descripcion, precio) VALUES (?, ?, ?, ?)");
			
			ps.setInt(1, id_hotel);
			ps.setString(2, numero);
			ps.setString(3, descripcion);
			ps.setDouble(4, precio);
			
			ResultSet rs = ps.executeQuery();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	} 
	
	public void eliminarHabitacion(int id) {
		
		try {
			PreparedStatement ps = con.getConexion().prepareStatement("DELETE FROM habitaciones WHERE id=?");
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void editarHabitacion(int id, int id_hotel, String numero, String descripcion, double precio) {
		try {
			PreparedStatement ps = con.getConexion().prepareStatement("UPDATE habitaciones SET id_hotel=?, numero=?, "
					+ "descripcion=?, precio=?  WHERE id=?");
			
			ps.setInt(1, id_hotel);
			ps.setString(2, numero);
			ps.setString(3, descripcion);
			ps.setDouble(4, precio);
			ps.setInt(5, id);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
