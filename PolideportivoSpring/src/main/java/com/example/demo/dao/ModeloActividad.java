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

public class ModeloActividad extends Conector {

	public List<Actividad> selectAll() {
		List<Actividad> actividades = new ArrayList<Actividad>();
		try {
			PreparedStatement pst = super.conexion.prepareStatement("select * from actividades");
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Actividad actividad = new Actividad();
				actividad.setId(rs.getInt("id"));
				actividad.setNombre(rs.getString("nombre"));
				actividad.setDias(rs.getString("dias_semana"));
				actividad.setFecha_inicio(rs.getDate("fecha_inicio"));
				actividad.setHoras(rs.getInt("horas"));
				actividad.setMaxParticipantes(rs.getInt("max_participantes"));
				actividad.setPrecio(rs.getDouble("precio"));

				actividades.add(actividad);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actividades;
	}

	public Actividad getConUsuariosInscritos(int idActividad) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("select inscripciones.*, usuarios.* "
					+ "from inscripciones join usuarios on inscripciones.id_usuario= usuarios.id "
					+ "where inscripciones.id_actividad = ?");
			pst.setInt(1, idActividad);

			ResultSet rs = pst.executeQuery();
			Actividad actividad = new Actividad();
			List<Inscripcion> inscripciones = new ArrayList<Inscripcion>();

			while (rs.next()) {

				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("usuarios.id"));
				usuario.setNombreApellido(rs.getString("usuarios.nombre_apellido"));
				usuario.setDni(rs.getString("usuarios.dni"));
				usuario.setCodigo(rs.getString("usuarios.codigo"));

				Inscripcion inscripcion = new Inscripcion();
				inscripcion.setUsuario(usuario);
				inscripciones.add(inscripcion);

			}
			actividad.setIscripciones(inscripciones);

			return actividad;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Actividad get(int idActividad) {

		PreparedStatement pst;
		try {
			pst = super.conexion.prepareStatement("select * from actividades where id= ?");
			pst.setInt(1, idActividad);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				Actividad actividad = new Actividad();
				actividad.setId(rs.getInt("id"));
				actividad.setNombre(rs.getString("nombre"));
				actividad.setDias(rs.getString("dias_semana"));
				actividad.setFecha_inicio(rs.getDate("fecha_inicio"));
				actividad.setHoras(rs.getInt("horas"));
				actividad.setMaxParticipantes(rs.getInt("max_participantes"));
				actividad.setPrecio(rs.getDouble("precio"));

				return actividad;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public void update(Actividad actividad) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("UPDATE actividades "
					+ "SET nombre=?, dias_semana = ?, fecha_inicio=?, horas=?, max_participantes=?, precio=? "
					+ "WHERE id = ?");
			pst.setString(1, (actividad).getNombre());
			pst.setString(2, (actividad).getDias());
			pst.setDate(3, new java.sql.Date((actividad).getFecha_inicio().getTime()));
			pst.setInt(4, (actividad).getHoras());
			pst.setInt(5, (actividad).getMaxParticipantes());
			pst.setDouble(6, (actividad).getPrecio());
			pst.setInt(7, (actividad).getId());
			pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void insert(Actividad actividad) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement(
					"insert into actividades (nombre, fecha_inicio, dias_semana, horas, max_participantes, precio) values (?, ?, ?, ?, ?, ?)");
			pst.setString(1, actividad.getNombre());
			pst.setDate(2, new java.sql.Date(actividad.getFecha_inicio().getTime()));
			pst.setString(3, actividad.getDias());
			pst.setInt(4, actividad.getHoras());
			pst.setInt(5, actividad.getMaxParticipantes());
			pst.setDouble(6, actividad.getPrecio());

			pst.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(Actividad actividad) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("DELETE FROM actividades WHERE id=?");
			pst.setInt(1, actividad.getId());
			pst.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int id) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("DELETE FROM actividades WHERE id=?");
			pst.setInt(1, id);
			pst.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
