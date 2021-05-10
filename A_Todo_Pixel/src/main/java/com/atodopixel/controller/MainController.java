package com.atodopixel.controller;

import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atodopixel.model.dao.JuegoModel;

@Controller
public class MainController {
	
	@Autowired
	JdbcTemplate db;
	
	@Autowired
	JuegoModel jm;
}
