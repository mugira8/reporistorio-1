package Aplicacion;
import java.util.*;  
import java.sql.*;
import Modelos.*;
import Conexion.*;
import Objetuak.*;

public class Main{	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Conector con = new Conector();
		Kudeatzailea kude = new Kudeatzailea();
		ModeloCliente mc = new ModeloCliente();
		ModeloHabitaciones mha = new ModeloHabitaciones();
		ModeloHoteles mho = new ModeloHoteles();
		ModeloReservas mr = new ModeloReservas();
		
		
		Scanner input = new Scanner(System.in);
		int aukera=1, i=0;
		String usuario, contrasenia, dni, nombre, apellidos, direccion, localidad;
		
		do {
			do {
			System.out.println("Introduce el nombre de usuario");
			usuario = input.nextLine();
			System.out.println("introduce la contraseña");
			contrasenia = input.nextLine();
			try {
			PreparedStatement ps = con.getConexion().prepareStatement("SELECT * FROM usuario WHERE username=? AND password=?");
			ps.setString(1, usuario);
			ps.setString(2, contrasenia);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				do { kude.menuPrincipal();
				aukera =Integer.parseInt(input.nextLine());
				
				switch(aukera) {
				case 1:
					do{kude.menuCliente(); 
					aukera = Integer.parseInt(input.nextLine());
					
					switch(aukera) {
					case 1:
						ArrayList<Cliente> clienteslist1 = mc.listarClientes();
						Iterator<Cliente> iteratorcliente1 = clienteslist1.iterator();
						
						while(iteratorcliente1.hasNext()) {
							System.out.println(iteratorcliente1.next());
						}
						
					break;
					case 2: System.out.println("Introduce DNI, nombre o apellido para hacer la busqueda");
							String busqueda = input.nextLine();
							
							ArrayList<Cliente> clienteslist2 = mc.buscarClientes(busqueda);
							Iterator<Cliente> iteratorcliente2 = clienteslist2.iterator();
							
							while(iteratorcliente2.hasNext()) {
								System.out.println(iteratorcliente2.next());
							}
					break;
					case 3: System.out.println("Introduce DNI del cliente");
							dni = input.nextLine();
							System.out.println("Introduce nombre del cliente");
							nombre = input.nextLine();
							System.out.println("Introduce apellidos del cliente");
							apellidos = input.nextLine();
							System.out.println("Introduce direccion del cliente");
							direccion = input.nextLine();
							System.out.println("Introduce localidad del cliente");
							localidad = input.nextLine();
							
							mc.añadirCliente(dni, nombre, apellidos, direccion, localidad);
						
					break;
					case 4:System.out.println("Introduce dni del cliente que quieras eliminar");
					dni = input.nextLine();
					
					mc.eliminarCliente(dni);

					break;
					case 5: System.out.println("Introduce el DNI del cliente que quieres editar");
					dni = input.nextLine();
					System.out.println("Introduce el nombre");
					nombre = input.nextLine();
					System.out.println("Introduce el apellido");
					apellidos = input.nextLine();
					System.out.println("Introduce la direccion");
					direccion = input.nextLine();
					System.out.println("Introduce la localidad");
					localidad = input.nextLine();
					mc.editarCliente(dni, nombre, apellidos, direccion, localidad);
					
					}
					}while(aukera != 0);
				break;
				case 2:do{kude.menuHoteles(); 
				aukera = Integer.parseInt(input.nextLine());
				
				switch(aukera) {
				case 1:ArrayList<Hoteles> hoteleslist1 = mho.listarHoteles();
				
				break;
				case 2:;
				break;
				case 3:;
				break;
				case 4:;
				break;
				}
				}while(aukera != 0);;
				break;
				case 3:
					do{kude.menuHabitaciones(); 
				aukera = Integer.parseInt(input.nextLine());
				
				switch(aukera) {
				case 1:; 
				break;
				case 2:;
				break;
				case 3:;
				break;
				case 4:;
				break;
				}
				}while(aukera != 0);;
				break;
				case 4:
					do{kude.menuReservas(); 
				aukera = Integer.parseInt(input.nextLine());
					
				switch(aukera) {
				case 1:; 
				break;
				case 2:;
				break;
				case 3:;
				break;
				case 4:;
				break;
				}
				}while(aukera != 0);;
				break;
				}
				}while(aukera != 0);
			}
			else {
				i++;
			}
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
			}while(i<=3 || aukera !=0);
			aukera = 0;
			
		}while(aukera != 0);
		System.out.println("=== FIN ===");
	}

}
