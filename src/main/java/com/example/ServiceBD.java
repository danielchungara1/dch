package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ServiceBD {
	Connection ConexionDb;
	String query;
	PreparedStatement sentenciaSql;
	ResultSet rs;
	BaseDatos bd;

	public ServiceBD() {
		// Instancias la clase que hemos creado anteriormente
		bd = new BaseDatos();

	}

	public Producto getProducto() throws Exception {

		// Llamas al método que tiene la clase y te devuelve una conexión
		ConexionDb = bd.conectarMySQL();

		query = "SELECT  p.precio, i.url FROM Producto p, Imagen i limit 1";
		sentenciaSql = ConexionDb.prepareStatement(query);
		rs = sentenciaSql.executeQuery();

		Producto p = new Producto();
		while (rs.next()) {
			String precio = rs.getString("precio");
			String url = rs.getString("url");

			p.precio = precio;
			p.url = url;

		}
		return p;
	}

	public List<Producto> getProductos(int n) throws Exception {

		ConexionDb = bd.conectarMySQL();

		query = " SELECT  p.id_producto, p.precio, i.url FROM Producto p inner join Imagen i on p.id_producto = i.id_producto limit " + n;
		sentenciaSql = ConexionDb.prepareStatement(query);
		rs = sentenciaSql.executeQuery();

		List<Producto> lp = new ArrayList<Producto>();
		while (rs.next()) {
			String precio = rs.getString("precio");
			String url = rs.getString("url");
			String id_producto = rs.getString("id_producto");

			Producto p = new Producto();
			p.precio = precio;
			p.url = url;
			p.id_producto = id_producto;
			
			lp.add(p);

		}
		return lp;
	}
	
	public Producto getProductoById(String id_producto) throws Exception {

		ConexionDb = bd.conectarMySQL();

		query = "SELECT  p.id_producto, p.precio, i.url FROM Producto p inner join Imagen i on p.id_producto = i.id_producto where p.id_producto=" + id_producto;
		sentenciaSql = ConexionDb.prepareStatement(query);
		rs = sentenciaSql.executeQuery();

		Producto p = new Producto();

		while (rs.next()) {
			p.precio = rs.getString("precio");
			p.url = rs.getString("url");
			p.id_producto = rs.getString("id_producto");
			
		}
		return p;
	}

}
