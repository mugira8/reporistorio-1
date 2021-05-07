package com.example.demo.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.example.demo.bean.Conector;
import com.example.demo.bean.Usuario;

public class ModeloUsuario extends Conector{
	
	
	/**
	 * Nos devuelve la lista de usuarios completa que tenemos en la base de datos
	 * @author aitor
	 * @return Lista de usuarios
	 * @version 1.0
	 */
	
	public List<Usuario> selectAll(){
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from usuarios");
			while(rs.next()){
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNombreApellido(rs.getString("nombre_apellido"));
				usuario.setDni(rs.getString("dni"));
				usuario.setCodigo(rs.getString("codigo"));
				
				usuarios.add(usuario);
			}
			return usuarios;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}
	
	/**
	 * Comprueba si el usuario de la base de datos tiene codigo
	 * @author aitor
	 * @param codigo
	 * @return True/False
	 * @version 1.0
	 */
	

	public boolean existCodigo(String codigo) {
		PreparedStatement pst;
		try {
			pst = super.conexion.prepareStatement("select * from usuarios where codigo = ?");
			pst.setString(1, codigo);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Comprueba si el usuario de la base de datos tiene DNI
	 * @author aitor
	 * @param dni
	 * @return True/false
	 * @version 1.0
	 */
	public boolean existDni(String dni) {
		PreparedStatement pst;
		try {
			pst = super.conexion.prepareStatement("select * from usuarios where dni = ?");
			pst.setString(1, dni);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Nos dice si el usuario que tenga x DNI existe
	 * @author aitor
	 * @param usuario
	 * @return true/false
	 * @version 1.0
	 */
	public boolean exist(Usuario usuario) {
		PreparedStatement pst;
		try {
			pst = super.conexion.prepareStatement("select * from usuarios where dni = ?");
			pst.setString(1, usuario.getDni());
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * Comprueba si existe el id de usuario
	 * @author aitor
	 * @param id
	 * @return True/False
	 * @version 1.0
	 */
	
	public boolean existId(int id) {
		PreparedStatement pst;
		try {
			pst = super.conexion.prepareStatement("select * from usuarios where id = ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Muestra a los usuarios usando el codigo
	 * @author aitor
	 * @param codigo
	 * @return Usuario
	 * @version 1.0
	 */
	public Usuario getPorCodigo(String codigo) {
		PreparedStatement pst;
		try {
			pst = super.conexion.prepareStatement("select * from usuarios where codigo = ?");
			pst.setString(1, codigo);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNombreApellido(rs.getString("nombre_apellido"));
				usuario.setDni(rs.getString("dni"));
				usuario.setCodigo(rs.getString("codigo"));
				
				return usuario;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	
	}
	
	/**
	 * Muestra a los usuarios usando el dni
	 * @author aitor
	 * @param dni
	 * @return Usuario
	 * @version 1.0
	 */
	public Usuario getPorDni(String dni) {
		PreparedStatement pst;
		try {
			pst = super.conexion.prepareStatement("select * from usuarios where dni = ?");
			pst.setString(1, dni);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNombreApellido(rs.getString("nombre_apellido"));
				usuario.setDni(rs.getString("dni"));
				usuario.setCodigo(rs.getString("codigo"));
				
				return usuario;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	
	}
	
	/**
	 * Muestra a los usuarios usando el id
	 * @author aitor
	 * @param id
	 * @return Usuario
	 * @version 1.0
	 */
	public Usuario get(int id) {
		PreparedStatement pst;
		try {
			pst = super.conexion.prepareStatement("select * from usuarios where id = ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNombreApellido(rs.getString("nombre_apellido"));
				usuario.setDni(rs.getString("dni"));
				usuario.setCodigo(rs.getString("codigo"));
				
				return usuario;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	
	}

	/**
	 * Inserta un nuevo usuario en la base de datos usando usuario
	 * @author aitor
	 * @param usuario
	 * @version 1.0
	 */
	public void insert(Usuario usuario) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("insert into usuarios (nombre_apellido, dni, codigo) values (?, ?, ?)");
			pst.setString(1, usuario.getNombreApellido());
			pst.setString(2, usuario.getDni());
			pst.setString(3, usuario.getCodigo());
			
			pst.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Inserta un nuevo usuario en la base de datos usando cada parametro del mismo
	 * @author aitor
	 * @param nombreApellido, dni, codigo
	 * @version 1.0
	 */
	public void insert(String nombreApellido, String dni, String codigo) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("insert into usuarios (nombre_apellido, dni, codigo) values (?, ?, ?)");
			pst.setString(1, nombreApellido);
			pst.setString(2, dni);
			pst.setString(3, codigo);
			
			pst.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Muestra a los usuarios con inscripciones
	 * @author aitor
	 * @return Usuario
	 * @version 1.0
	 */
	public List<Usuario> usuariosConInscripciones(){
		ModeloInscripcion mInscripcion = new ModeloInscripcion();
		
		List<Usuario> usuarios = this.selectAll();
		for (Iterator iterator = usuarios.iterator(); iterator.hasNext();) {
			Usuario usuario = (Usuario) iterator.next();
			usuario.setInscripciones(mInscripcion.getActividadesDeUsuario(usuario.getId()));
		}
		return usuarios;
	}
	
	/**
	 * Muestra a los usuarios con inscripciones usando el id
	 * @author aitor
	 * @param idUsuario
	 * @return Usuario
	 * @version 1.0
	 */
	public Usuario usuarioConInscripciones(int idUsuario){
		ModeloInscripcion mInscripcion = new ModeloInscripcion();
		
		Usuario usuario = this.get(idUsuario);
		usuario.setInscripciones(mInscripcion.getActividadesDeUsuario(idUsuario));
		
		return usuario;
	}

	/**
	 * Muestra a los usuarios usando el id
	 * @author aitor
	 * @param id, nombre_apellido
	 * @version 1.0
	 */
	public void updateNombreApellido(int id, String nombre_apellido) {
		PreparedStatement pst;
		try {
			pst = super.conexion.prepareStatement("update usuarios set nombre_apellido=? where id=?");
			
			pst.setString(1, nombre_apellido);
			pst.setInt(2, id);
			
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Actualiza el dni de los usuairos
	 * @author aitor
	 * @param id, dni
	 * @version 1.0
	 */
	public void updateDni(int id, String dni) {
		PreparedStatement pst;
		try {
			pst = super.conexion.prepareStatement("update usuarios set dni=? where id=?");
			
			pst.setString(1, dni);
			pst.setInt(2, id);
			
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Actualiza el codigo de los usuairos
	 * @author aitor
	 * @param id, codigo
	 * @version 1.0
	 */
	public void updateCodigo(int id, String codigo) {
		PreparedStatement pst;
		try {
			pst = super.conexion.prepareStatement("update usuarios set codigo=? where id=?");
			
			pst.setString(1, codigo);
			pst.setInt(2, id);
			
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Actualiza el usuario
	 * @author aitor
	 * @param usuario
	 * @version 1.0
	 */
	public void update(Usuario usuario) {
		PreparedStatement pst;
		try {
			pst = super.conexion.prepareStatement("update usuarios set nombre_apellido=?, dni=?, codigo=? where id=?");
			
			pst.setString(1, usuario.getNombreApellido());
			pst.setString(2, usuario.getDni());
			pst.setString(3, usuario.getNombreApellido());
			pst.setInt(4, usuario.getId());
			
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Elimina el usuario
	 * @author aitor
	 * @param usuario
	 * @version 1.0
	 */
	public void delete(Usuario usuario) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("DELETE FROM usuarios WHERE id=?");
			pst.setInt(1, usuario.getId());
			pst.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Actualiza el usuario usando el id
	 * @author aitor
	 * @param idUsuario
	 * @version 1.0
	 */
	public void delete(int idUsuario) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("DELETE FROM usuarios WHERE id=?");
			pst.setInt(1, idUsuario);
			pst.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
