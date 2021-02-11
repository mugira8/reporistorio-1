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
		ArrayList<Hoteles> clienteslist = new ArrayList<Hoteles>();
		
		try {
			PreparedStatement ps = con.getConexion().prepareStatement("SELECT * "
					+ "FROM hoteles");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				clienteslist.add(new Hoteles(rs.getInt("id"), 
						rs.getString("cif"), rs.getString("nombre"), 
						rs.getString("gerente"), rs.getInt("estrellas"),
						rs.getString("compania")));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return clienteslist;
	}
	
	
}
