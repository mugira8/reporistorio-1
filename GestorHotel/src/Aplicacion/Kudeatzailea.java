package Aplicacion;
import java.sql.*;
import java.util.*;

import Conexion.Conector;


public class Kudeatzailea {
	
	Scanner input = new Scanner (System.in);
	Conector con = new Conector();
	
	public void menuLogin() {
		System.out.println("============== Menu ==============\r\n"
				+ "0. Salir\r\n"
				+ "1. Login\r\n"
				+ "==================================");
	}
	
	public void menuPrincipal() {
		
		System.out.println("============== Menu ==============\r\n"
				+ "0. Salir\r\n"
				+ "1. Gestionar clientes\r\n"
				+ "2. Gestionar hoteles\r\n"
				+ "3. Gestionar habitaciones\r\n"
				+ "4. Gestionar reservas\r\n"
				+ "==================================");
	}
	
	public void menuCliente() {
		
		System.out.println("============== Menu ==============\r\n"
				+ "0. Salir\r\n"
				+ "1. Mostrar todos los clientes\r\n"
				+ "2. Buscar cliente\r\n"
				+ "3. Añadir cliente\r\n"
				+ "4. Eliminar cliente\r\n"
				+ "5. Editar cliente \r\n"
				+ "==================================");
	}
	
	public void menuHoteles() {
		
		System.out.println("============== Menu ==============\r\n"
				+ "0. Salir\r\n"
				+ "1. Mostrar todos los hoteles\r\n"
				+ "2. Buscar hotel\r\n"
				+ "3. Añadir hotel\r\n"
				+ "4. Eliminar hotel\r\n"
				+ "5. Editar hotel\r\n"
				+ "==================================");
	}
	
	public void menuHabitaciones() {
		
		System.out.println("============== Menu ==============\r\n"
				+ "0. Salir\r\n"
				+ "1. Mostrar todas las habitaciones\r\n"
				+ "2. Buscar habitaciones\r\n"
				+ "3. Añadir habitacion\r\n"
				+ "4. Eliminar habitacion\r\n"
				+ "5. Editar habitacion\r\n"
				+ "==================================");
	}
	public void menuReservas() {
		
		System.out.println("============== Menu ==============\r\n"
				+ "0. Salir\r\n"
				+ "1. Mostrar habitaciones\r\n"
				+ "2. Buscar reserva\r\n"
				+ "3. Añadir reserva\r\n"
				+ "4. Eliminar reserva\r\n"
				+ "5. Editar reserva\r\n"
				+ "==================================");
	}
	
	public boolean login() {
		boolean login = false;
		String contrasenia, usuario;
		int i = 0;
		
		do {
		System.out.println("Introduce el nombre de usuario");
		usuario = input.nextLine();
		System.out.println("Introduce la contraseña");
		contrasenia = input.nextLine();
		try {
		PreparedStatement ps = con.getConexion().prepareStatement("SELECT * FROM usuario WHERE username=? AND password=?");
		
		ps.setString(1, usuario);
		ps.setString(2, contrasenia);
		
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			login = true;
			return login;
		}
		else {
			i++;
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		} while(i <= 2);
		
		login = false;
		return login;
	}
}
