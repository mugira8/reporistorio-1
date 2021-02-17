package Modelos;

import java.sql.PreparedStatement;  
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.Conector;
import Objetuak.Hoteles;

public class ModeloHoteles {

Conector con = new Conector();
	
	public ArrayList<Hoteles> listarHoteles(){
		ArrayList<Hoteles> hoteleslist = new ArrayList<Hoteles>();
		
		try {
			PreparedStatement ps = con.getConexion().prepareStatement("SELECT * "
					+ "FROM hoteles");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				hoteleslist.add(new Hoteles(rs.getInt("id"), 
						rs.getString("cif"), rs.getString("nombre"), 
						rs.getString("gerente"), rs.getInt("estrellas"),
						rs.getString("compania")));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return hoteleslist;
	}
	
	public ArrayList<Hoteles> buscarHoteles(String busqueda){
		ArrayList<Hoteles> hoteleslist = new ArrayList<Hoteles>();
		
		try {
			PreparedStatement ps = con.getConexion().prepareStatement("SELECT * "
					+ "FROM hoteles WHERE cif LIKE ? OR nombre LIKE ? OR "
					+ "gerente LIKE ? OR estrellas LIKE  ? OR compania LIKE ?");
			
			ps.setString(1, "%" + busqueda + "%");
			ps.setString(2, "%" + busqueda + "%");
			ps.setString(3, "%" + busqueda + "%");
			ps.setString(4, "%" + busqueda + "%");
			ps.setString(5, "%" + busqueda + "%");

			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				hoteleslist.add(new Hoteles(rs.getInt("id"), 
						rs.getString("cif"), rs.getString("nombre"), 
						rs.getString("gerente"), rs.getInt("estrellas"),
						rs.getString("compania")));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		return hoteleslist;
	}
	
	public void aniadirHotel(String cif, String nombre, String gerente, int estrellas, String compania) {
		
		try {
			PreparedStatement ps = con.getConexion().prepareStatement("INSERT INTO hoteles "
					+ "(cif, nombre. gerente, estrellas, compania) VALUES (?, ?, ?, ?, ?)");
			
			ps.setString(1, cif);
			ps.setString(2, nombre);
			ps.setString(3, gerente);
			ps.setInt(4, estrellas);
			ps.setString(5, compania);
			
			ResultSet rs = ps.executeQuery();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void eliminarHotel(String cif) {
		
		try {
			PreparedStatement ps = con.getConexion().prepareStatement("DELETE FROM hoteles WHERE cif=?");
			
			ps.setString(1, cif);
			
			ResultSet rs = ps.executeQuery();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void editarHotel (String cif, String nombre, String gerente, int estrellas, String compania) {
		try {
			PreparedStatement ps = con.getConexion().prepareStatement("UPDATE hoteles SET nombre=?, gerente=?, "
					+ "estrellas=?, compania=?  WHERE cif=?");
			
			ps.setString(1, nombre);
			ps.setString(2, gerente);
			ps.setInt(3, estrellas);
			ps.setString(4, compania);
			ps.setString(5, cif);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
