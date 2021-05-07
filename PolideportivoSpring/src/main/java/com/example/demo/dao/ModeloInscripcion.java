package com.example.demo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.bean.Actividad;
import com.example.demo.bean.Conector;
import com.example.demo.bean.Inscripcion;
import com.example.demo.bean.Usuario;


public class ModeloInscripcion extends Conector{
	
	public void inscribir(Usuario usuario, Actividad actividad) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("INSERT INTO inscripciones(id_usuario, id_actividad) VALUES (?, ?)");
			pst.setInt(1, usuario.getId());
			pst.setInt(2, actividad.getId());
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void inscribir(int id_usuario, int id_actividad) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("INSERT INTO inscripciones(id_usuario, id_actividad) VALUES (?, ?)");
			pst.setInt(1, id_usuario);
			pst.setInt(2, id_actividad);
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void delete(Inscripcion inscripcion) {
		PreparedStatement pst;
		try {
			pst = super.conexion.prepareStatement("DELETE FROM `inscripciones` WHERE id_usuario=? and id_actividad=?");
			pst.setInt(1, inscripcion.getUsuario().getId());
			pst.setInt(2, inscripcion.getActividad().getId());
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void delete(int idActividad, int idUsuario) {
		PreparedStatement pst;
		try {
			pst = super.conexion.prepareStatement("DELETE FROM `inscripciones` WHERE id_usuario=? and id_actividad=?");
			pst.setInt(1, idUsuario);
			pst.setInt(2, idActividad);
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	public List<Usuario> getUsuariosInscritos(int idActividad) {
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			PreparedStatement pst = super.conexion.prepareStatement("select usuarios.* "
					+ "from inscripciones join usuarios on inscripciones.id_usuario= usuarios.id "
					+ "where inscripciones.id_actividad = ?");
			pst.setInt(1, idActividad);

			ResultSet rs = pst.executeQuery();
			
			
			while(rs.next()){
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNombreApellido(rs.getString("nombre_apellido"));
				usuario.setDni(rs.getString("dni"));
				usuario.setCodigo(rs.getString("codigo"));
				
				usuarios.add(usuario);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
		
	}


	public List<Inscripcion> getActividadesDeUsuario(int idUsuario) {
		ModeloActividad mActividad = new ModeloActividad();
		List<Inscripcion> inscripciones = new ArrayList<Inscripcion>();
		
		try {
			PreparedStatement pst = super.conexion.prepareStatement("select * from inscripciones where id_usuario = ?");
			pst.setInt(1, idUsuario);

			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				Inscripcion inscripcion = new Inscripcion();
				inscripcion.setActividad(mActividad.get(rs.getInt("id_actividad")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return inscripciones;
	}
	
	
}
