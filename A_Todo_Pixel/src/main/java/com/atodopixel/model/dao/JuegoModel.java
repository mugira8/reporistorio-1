package com.atodopixel.model.dao;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.atodopixel.model.bean.Juego;

public class JuegoModel {
	
	@Autowired
    JdbcTemplate db;
	
	public JuegoModel() {}
	
	public JuegoModel(JdbcTemplate db) {
		this.db=db;
	}
	
	public List<Juego> selectJuegos(){
		List<Juego> juegos = new ArrayList<Juego>();
		
		String sql = "SELECT * FROM juego";
		
		SqlRowSet rs =  db.queryForRowSet(sql);
		
		return juegos;
	}
}
