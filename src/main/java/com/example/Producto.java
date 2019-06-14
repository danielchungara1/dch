package com.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Producto {
	public String id_producto;
	public String precio;
	public String descripcion;

	public List<Imagen> imagenes;
	public List<Caracteristica> caracteristicas;
	public Publicacion publicacion;
	
	public static Producto factoryProducto(ResultSet rs) throws SQLException {
		Producto p = new Producto();
		while (rs.next()) {
			String precio = rs.getString("precio");
			//String url = rs.getString("url");

			p.precio = precio;
			//p.url = url;

		}

		return p;
	}

	public static Producto factoryProducto(ResultSet rsproducto,ResultSet rsimagenes, ResultSet rscaracteristicas, ResultSet rspublicacion) throws SQLException {
		Producto p = new Producto();
		while (rsproducto.next()) {
			p.precio = rsproducto.getString("precio");
			p.descripcion = rsproducto.getString("descripcion");
			p.id_producto = rsproducto.getString("id_producto");
		}

		p.imagenes = Imagen.factoryImagenes(rsimagenes);
		p.caracteristicas = Caracteristica.factoryCaracteristicas(rscaracteristicas);
		p.publicacion = Publicacion.factoryPublicacion(rspublicacion); 
				
		return p;
	}
	
	
}
