package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

	
	public Producto getProductoById(String id_producto) throws Exception {

		ConexionDb = bd.conectarMySQL();

		query = "SELECT  * FROM Producto p where id_producto="+ id_producto;
		sentenciaSql = ConexionDb.prepareStatement(query);
		ResultSet rsproducto = sentenciaSql.executeQuery();
		
		query = "SELECT  * FROM Imagen i where id_producto="+ id_producto;
		sentenciaSql = ConexionDb.prepareStatement(query);
		ResultSet rsimagenes = sentenciaSql.executeQuery();
		
		query = "SELECT  * FROM Caracteristica c where id_producto="+ id_producto;
		sentenciaSql = ConexionDb.prepareStatement(query);
		ResultSet rscaracteristicas = sentenciaSql.executeQuery();
		

		Producto p = Producto.factoryProducto(rsproducto, rsimagenes, rscaracteristicas);
		
		return p;
	}

	public List<Producto> getProductos(int n) throws Exception {

		List<Producto> lp = new ArrayList<Producto>();
		
		List<String> lids = this.getListIdsProducto(n);
		
		for (String id: lids) {
			lp.add(this.getProductoById(id));
		}
		return lp;
	}


	private List<String> getListIdsProducto(int n) throws SQLException {
		List<String> lids = new ArrayList<String>();
		ConexionDb = bd.conectarMySQL();

		query = "SELECT  p.id_producto FROM Producto p limit " + n;
		sentenciaSql = ConexionDb.prepareStatement(query);
		ResultSet rsids = sentenciaSql.executeQuery();
		
		while (rsids.next()) {

			String id = rsids.getString("id_producto");
			lids.add(id);
		}
		return lids;
	}
	
}
