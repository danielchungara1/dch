package com.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Imagen {
	public String id_imagen;
	public String id_producto;
	public String url;
	public String descripcion;
	
	/*************************DEPRECADO***************************/
	@Deprecated
	public static List<Imagen> factoryImagenes(ResultSet rsimagenes) throws SQLException {
		List<Imagen> imagenes = new ArrayList<Imagen>();
		while (rsimagenes.next()) {
			Imagen i = new Imagen();
			i.url = rsimagenes.getString("url");
			i.descripcion = rsimagenes.getString("descripcion");
			i.id_imagen = rsimagenes.getString("id_imagen");
			imagenes.add(i);
		}
		return imagenes;
	}
}
