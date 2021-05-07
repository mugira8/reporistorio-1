package Aplicacion;
import java.util.*;   
import java.sql.*;
import Modelos.*;
import Conexion.*;
import Objetuak.*;

public class Main{	
	
	//Crear comprobaciones antes y despues de ejecutar
	//INSERT, DELETE, UPDATE antes y despues de ejecutar.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Conector con = new Conector();
		Kudeatzailea kude = new Kudeatzailea();
		ModeloCliente mc = new ModeloCliente();
		ModeloHabitaciones mha = new ModeloHabitaciones();
		ModeloHoteles mho = new ModeloHoteles();
		ModeloReservas mr = new ModeloReservas();
		Reservas rese = new Reservas();
		
		Scanner input = new Scanner(System.in);
		int aukera=1, i=0, estrellas, id_hotel, id, id_habitacion;
		
		String dni, nombre, apellidos, direccion, localidad, cif, gerente, 
		compania, numero, descripcion, desdeNuevo, hastaNuevo, desde = null, hasta = null;
		
		double precio;
		
		boolean funciona, login = false;
		
		Reservas reservastemp;
		
		do { kude.menuLogin();
			aukera = Integer.parseInt(input.nextLine());
			switch(aukera) {
			case 0: 
				aukera = 0;
			break;
			case 1:
				login = kude.login();
				if (login == true) {
							
							do { kude.menuPrincipal();
							aukera =Integer.parseInt(input.nextLine());
							
							switch(aukera) {
							case 1: //menu cliente
								do{kude.menuCliente(); 
								aukera = Integer.parseInt(input.nextLine());
								
								switch(aukera) {
								case 1:
									login = kude.login();
									if (login == true) {
									ArrayList<Cliente> clienteslist1 = mc.listarClientes();
									Iterator<Cliente> iteratorcliente1 = clienteslist1.iterator();
									
									while(iteratorcliente1.hasNext()) {
										System.out.println(iteratorcliente1.next());
									}
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
										
										if (mc.aniadirCliente(dni, nombre, apellidos, direccion, localidad) == true) {
											System.out.println("Se ha aniadido el cliente con exito");
										}
										else {
											System.out.println("No se ha podido aniadir su cliente");
										}
									
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
								aukera=-1;
							break; //Fin menu cliente
							case 2: //Menu hoteles
								do{kude.menuHoteles(); 
							aukera = Integer.parseInt(input.nextLine());
							
							switch(aukera) {
							case 1:
								ArrayList<Hoteles> hoteleslist1 = mho.listarHoteles();
								Iterator<Hoteles> iteratorhoteles1 = hoteleslist1.iterator();
								
								while (iteratorhoteles1.hasNext()) {
									System.out.println(iteratorhoteles1.next());
								}
							break;
							case 2:
								System.out.println("Introduce algun dato para hacer la busqueda");
								String busqueda = input.nextLine();
								
								ArrayList<Hoteles> hoteleslist2 = mho.buscarHoteles(busqueda);
								Iterator<Hoteles> iteratorhoteles2 = hoteleslist2.iterator();
								
								while (iteratorhoteles2.hasNext()) {
									System.out.println(iteratorhoteles2.next());
								}
							break;
							case 3: 
								System.out.println("Introduce el CIF del hotel que quieras añadir");
								cif = input.nextLine();
								System.out.println("Introduce el nombre");
								nombre = input.nextLine();
								System.out.println("Introduce el nombre del gerente");
								gerente = input.nextLine();
								System.out.println("Introduce las cantidad de estrellas");
								estrellas = Integer.parseInt(input.nextLine());
								System.out.println("Introduce el nombre de la compania");
								compania = input.nextLine();
								
								mho.aniadirHotel(cif, nombre, gerente, estrellas, compania);
								
							break;
							case 4:
								System.out.println("Introduce el CIF del hotel que quieras eliminar");
								cif = input.nextLine();
								
								mho.eliminarHotel(cif);
							break;
							case 5: 
								System.out.println("Introduce el CIF del hotel que quieras editar");
								cif = input.nextLine();
								System.out.println("Introduce el nombre");
								nombre = input.nextLine();
								System.out.println("Introduce el nombre del gerente");
								gerente = input.nextLine();
								System.out.println("Introduce las cantidad de estrellas");
								estrellas = Integer.parseInt(input.nextLine());
								System.out.println("Introduce el nombre de la compania");
								compania = input.nextLine();
								
								mho.editarHotel(cif, nombre, gerente, estrellas, compania);
							break;
							}
							}while(aukera != 0);
							aukera=-1;
							break; //fin menu hoteles
							case 3: //Menu habitaciones
								do{kude.menuHabitaciones(); 
							aukera = Integer.parseInt(input.nextLine());
							
							switch(aukera) {
							case 1:
								ArrayList<Habitaciones> habitacioneslist1 = mha.listarHabitaciones();
								Iterator<Habitaciones> iteratorhabitaciones1 = habitacioneslist1.iterator();
								
								while(iteratorhabitaciones1.hasNext()) {
									System.out.println(iteratorhabitaciones1.next());
								}
							break;
							case 2:
								System.out.println("Introduce algun dato para hacer la busqueda");
								String busqueda = input.nextLine();
								
								ArrayList<Habitaciones> habitacioneslist2 = mha.buscarHabitaciones(busqueda);
								Iterator<Habitaciones> iteratorhabitaciones2 = habitacioneslist2.iterator();
								
								while (iteratorhabitaciones2.hasNext()) {
									System.out.println(iteratorhabitaciones2.next());
								}
							break;
							case 3:
								System.out.println("Introduce el ID del Hotel que tenga la habitacion que quieres añadir");
								id_hotel =Integer.parseInt(input.nextLine()); 
								System.out.println("Introduce el numero de la habitacion");
								numero = input.nextLine();
								System.out.println("Introduce la descripcion");
								descripcion = input.nextLine();
								System.out.println("Introduce el precio de la habitacion");
								precio = Double.parseDouble(input.nextLine());
								
								
								mha.aniadirHabitacion(id_hotel, numero, descripcion, precio);
							break;
							case 4:
								System.out.println("Introduce el ID de la habitacion que quieras eliminar");
								id = Integer.parseInt(input.nextLine());
								
								mha.eliminarHabitacion(id);
							break;
							case 5:
								System.out.println("Introduce el ID del la habitacion");
								id =Integer.parseInt(input.nextLine()); 
								System.out.println("Introduce el ID del hotel de esa habitacion");
								id_hotel =Integer.parseInt(input.nextLine()); 
								System.out.println("Introduce el numero de la habitacion");
								numero = input.nextLine();
								System.out.println("Introduce la descripcion");
								descripcion = input.nextLine();
								System.out.println("Introduce el precio de la habitacion");
								precio = Double.parseDouble(input.nextLine());
								
								
								mha.editarHabitacion(id, id_hotel, numero, descripcion, precio);
							break;
							}
							}while(aukera != 0);
								aukera = -1;
							break; //Fin menu habitaciones
							case 4: //Menu reservas
								do{kude.menuReservas(); 
							aukera = Integer.parseInt(input.nextLine());
								
							switch(aukera) {
							case 1: 
								ArrayList<Reservas> reservaslist1 = mr.listarReservas();
								Iterator<Reservas> iteratorreservas1 = reservaslist1.iterator();
								
								while(iteratorreservas1.hasNext()) {
									System.out.println(iteratorreservas1.next());
								} 
							break;
							case 2:
								System.out.println("Introduce algun dato para hacer la busqueda");
								String busqueda = input.nextLine();
								
								ArrayList<Reservas> reservaslist2 = mr.listarReservas();
								Iterator<Reservas> iteratorreservas2 = reservaslist2.iterator();
								
								while(iteratorreservas2.hasNext()) {
									System.out.println(iteratorreservas2.next());
								} 
							break;
							case 3: 
								System.out.println("Introduzca el ID de la habitacion que quieres reservar");
								id_habitacion = Integer.parseInt(input.nextLine());
								System.out.println("Introduce el DNI");
								dni = input.nextLine();
								System.out.println("Introduce la fecha de entrada a la habitacion");
								desdeNuevo = input.nextLine();
								System.out.println("Introduce la fecha de salida de la habitacion");
								hastaNuevo = input.nextLine();
								
								ArrayList<Reservas> reservaslist3 = mr.listarReservas();
								Iterator<Reservas> iteratorreservas3 = reservaslist3.iterator();
								
								while (iteratorreservas3.hasNext()) {
									reservastemp = iteratorreservas3.next();
								
								if (id_habitacion == reservastemp.getId_habitacion()) {
									desde = rese.getDesde();
									hasta = rese.getHasta();
								}
								}
								funciona = mr.aniadirReserva(id_habitacion, dni, desdeNuevo, hastaNuevo, desde, hasta);
								
								if (funciona = true) {
									System.out.println("Se ha completado la reserva");
								}else {
									System.out.println("No se ha podido reservar en las fechas deseadas");
								}
								
							break;
							case 4:
								System.out.println("Introduzca el ID de la reserva que quieres eliminar");
								id = Integer.parseInt(input.nextLine());
								
								mr.eliminarReserva(id);
							break;
							case 5:
								System.out.println("Introduce el ID de la reserva que quieres editar");
								id = Integer.parseInt(input.nextLine());
								System.out.println("Introduzca el ID de la habitacion que quieres reservar");
								id_habitacion = Integer.parseInt(input.nextLine());
								System.out.println("Introduce el DNI");
								dni = input.nextLine();
								System.out.println("Introduce la fecha de entrada a la habitacion");
								desdeNuevo = input.nextLine();
								System.out.println("Introduce la fecha de salida de la habitacion");
								hastaNuevo = input.nextLine();
								
								ArrayList<Reservas> reservaslist4 = mr.listarReservas();
								Iterator<Reservas> iteratorreservas4 = reservaslist4.iterator();
								
								while (iteratorreservas4.hasNext()) {
									reservastemp = iteratorreservas4.next();
								
								if (id_habitacion == reservastemp.getId_habitacion()) {
									desde = rese.getDesde();
									hasta = rese.getHasta();
								}
								}
								
								funciona = mr.editarReserva(id, id_habitacion, dni, desdeNuevo, hastaNuevo, desde, hasta);
								
								if (funciona = true) {
									System.out.println("El cambio de reserva se ha completado");
								}else {
									System.out.println("No se han podido cambiar las fechas de la reserva");
								}
								
							break; 
							}
							}while(aukera != 0);
							aukera = -1;
							break; //fin menu reservas
							}
							}while(aukera != 0);
							aukera = -1; //fin menu prioncipal
						}
						else { //3 login hechos
							aukera = 0;
						}				
			break;
			}
			} while(aukera != 0); //login
		System.out.println("=== FIN ===");
	}

}
