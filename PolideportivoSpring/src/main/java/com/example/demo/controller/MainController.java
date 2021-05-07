package com.example.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.bean.Actividad;
import com.example.demo.bean.Usuario;
import com.example.demo.dao.ModeloActividad;
import com.example.demo.dao.ModeloUsuario;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String index(Model html) {
		return "index";
	}
	
	@RequestMapping("/verActividades")
	public String verActividades(Model html) {
		ModeloActividad ma = new ModeloActividad();
		List<Actividad> actividad = ma.selectAll();
		html.addAttribute("actividad", actividad);
		
		return "verActividades";
	}
	
	@RequestMapping("/verActividad")
	public String verActividad(@RequestParam("id") int id, @RequestParam Map<String, String> param, Model html) throws ParseException{
		
		ModeloActividad ma = new ModeloActividad();
		Actividad actividad;
		if(param.get("nombre") !=null) {

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			
			Date fechaConvertida = format.parse(param.get("fecha_inicio")); 
			
			actividad =  new Actividad(Integer.parseInt(param.get("id")), param.get("nombre"), fechaConvertida, param.get("dias_semana"), Integer.parseInt(param.get("horas")), Integer.parseInt(param.get("max_participantes")), Double.parseDouble(param.get("precio")));
			id=Integer.parseInt(param.get("id"));		
			ma.update(actividad);
		}
		
		System.out.println(id);
		actividad = ma.get(id);
		html.addAttribute("actividad", actividad);

		return "verActividad";
	}
	
	@RequestMapping("/formEditarActividad")
	public String formEditarActividad(@RequestParam("id") int id, Model html) {
		
		ModeloActividad ma = new ModeloActividad();
		Actividad actividad = ma.get(id);
		
		html.addAttribute("actividad", actividad);
		
		return "formEditarActividad";
	}
	
	@GetMapping("/error")
	public String error(Model html) {
		
		return "error";
	}
}
