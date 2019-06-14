package com.example;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Publicacion {
	public String id_publicacion;
	public String titulo;
	
	public static Publicacion factoryPublicacion(ResultSet rspublicacion) throws SQLException {
		Publicacion p = new Publicacion();
		while (rspublicacion.next()) {
			p.id_publicacion = rspublicacion.getString("id_publicacion");
			p.titulo = rspublicacion.getString("titulo");
		}
		return p;
	}

}
