package Modelos;
import java.util.*; 
import java.sql.*;
import Objetuak.*;
import Conexion.*;
public class ModeloCliente {

	Conector con = new Conector();
	
	public ArrayList<Cliente> listarClientes(){
		ArrayList<Cliente> clienteslist = new ArrayList<Cliente>();
		
		try {
			PreparedStatement ps = con.getConexion().prepareStatement("SELECT * "
					+ "FROM clientes");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				clienteslist.add(new Cliente(rs.getString("dni"), 
						rs.getString("nombre"), rs.getString("apellidos"), 
						rs.getString("direccion"), rs.getString("localidad")));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return clienteslist;
	}
	
	public ArrayList<Cliente> buscarClientes(String busqueda){
		ArrayList<Cliente> clienteslist = new ArrayList<Cliente>();
		
		try {
			PreparedStatement ps = con.getConexion().prepareStatement("SELECT * "
					+ "FROM clientes WHERE dni LIKE ? OR nombre LIKE ? "
					+ "OR apellidos LIKE ?");
			ps.setString(1, "%" + busqueda +"%" );
			ps.setString(2, "%" + busqueda +"%" );
			ps.setString(3, "%" + busqueda +"%" );

			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				clienteslist.add(new Cliente(rs.getString("dni"), 
						rs.getString("nombre"), rs.getString("apellidos"), 
						rs.getString("direccion"), rs.getString("localidad")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return clienteslist;
	}
	
	public void aniadirCliente(String dni, String nombre, String apellidos, String direccion, String localidad) {
		
		try {
			PreparedStatement ps = con.getConexion().prepareStatement("INSERT INTO clientes "
					+ "(dni, nombre, apellidos, direccion, localidad) VALUES (?, ?, ?, ?, ?)");
			
			ps.setString(1, dni);
			ps.setString(2, nombre);
			ps.setString(3, apellidos);
			ps.setString(4, direccion);
			ps.setString(5, localidad);
			
			ResultSet rs = ps.executeQuery();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void eliminarCliente(String busqueda) {
		
		try {
			PreparedStatement ps = con.getConexion().prepareStatement("DELETE FROM clientes WHERE dni=?");
			
			ps.setString(1, busqueda);
			
			ResultSet rs = ps.executeQuery();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void editarCliente (String dni, String nombre, String apellidos, String direccion, String localidad) {
		try {
			PreparedStatement ps = con.getConexion().prepareStatement("UPDATE clientes SET nombre=?, apellidos=?, "
					+ "direccion=?, localidad=?  WHERE dni=?");
			
			ps.setString(1, nombre);
			ps.setString(2, apellidos);
			ps.setString(3, direccion);
			ps.setString(4, localidad);
			ps.setString(5, dni);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
