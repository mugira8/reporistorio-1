package Modelos;

import java.util.*;
import java.util.Date;
import java.sql.*;
import Objetuak.Reservas;

import org.joda.time.Interval;
import org.joda.time.base.*;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class ModeloReservas {
	
	public ArrayList<Reservas> listarReservas(){
		ArrayList<Reservas> reservaslist = new ArrayList<Reservas>();
		
		return reservaslist;
	}
	
	public boolean seSolapan(String fechaInicio1, String fechaFin1, 
			String fechaInicio2, String fechaFin2) {
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
		
		boolean seSolapan;
		
		
		Interval intervalo1 = new Interval (formatter.parseDateTime(fechaInicio1), formatter.parseDateTime(fechaFin1));
		Interval intervalo2 = new Interval (formatter.parseDateTime(fechaInicio2), formatter.parseDateTime(fechaFin2));
		
		if(intervalo1.overlaps(intervalo2) ) {
			seSolapan = true;
		}
		else {
			seSolapan = false;
		}
		return seSolapan;
	}
}
