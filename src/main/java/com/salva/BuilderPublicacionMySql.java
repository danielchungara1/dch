package com.salva;

import java.sql.ResultSet;
import java.util.List;

import com.model.Publicacion;

public class BuilderPublicacionMySql{
	public ResultSet rsPublicacion;
	
	public BuilderPublicacionMySql(ResultSet rspublicacion) {
		// TODO Auto-generated constructor stub
		this.rsPublicacion = rspublicacion;
	}
	public List<Publicacion> build(){
		return null;
	}
}
