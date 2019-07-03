package com.salva;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.data.ManagerMySql;
import com.model.Producto;
import com.model.Publicacion;

@Service
public class ServiceBD {
	Connection ConexionDb;
	String query;
	PreparedStatement sentenciaSql;
	ResultSet rs;
	ManagerMySql bd;

	public ServiceBD() {
		// Instancias la clase que hemos creado anteriormente
		bd = new ManagerMySql();

	}
	public Producto getProductoById(String id_producto) throws Exception {

		ConexionDb = ManagerMySql.getConnection();

		query = "SELECT  * FROM Producto p where id_producto="+ id_producto;
		sentenciaSql = ConexionDb.prepareStatement(query);
		ResultSet rsproducto = sentenciaSql.executeQuery();
		
		query = "SELECT  * FROM Imagen i where id_producto="+ id_producto;
		sentenciaSql = ConexionDb.prepareStatement(query);
		ResultSet rsimagenes = sentenciaSql.executeQuery();
		
		query = "SELECT  * FROM Caracteristica c where id_producto="+ id_producto;
		sentenciaSql = ConexionDb.prepareStatement(query);
		ResultSet rscaracteristicas = sentenciaSql.executeQuery();
		
		query = "SELECT  * FROM Publicacion p where id_producto="+ id_producto;
		sentenciaSql = ConexionDb.prepareStatement(query);
		ResultSet rspublicacion = sentenciaSql.executeQuery();
		
		Producto p = Producto.factoryProducto(rsproducto, rsimagenes, rscaracteristicas,rspublicacion);

		
		/**
		query = "SELECT  * FROM Vendedor v where id_vendedor="+ p.publicacion.id_vendedor;
		sentenciaSql = ConexionDb.prepareStatement(query);
		ResultSet rsvendedor = sentenciaSql.executeQuery();
			**/
		
		
		return p;
	}

	public List<Producto> getProductos(int n) throws Exception {

		List<Producto> lp = new ArrayList<Producto>();
		
		//List<String> lids = this.getListIdsProducto(n);
		List<String> lids = this.getListIdsHardcodeado();

		for (String id: lids) {
			lp.add(this.getProductoById(id));
		}
		return lp;
	}


	private List<String> getListIdsHardcodeado() {
		// TODO Auto-generated method stub
		List<String> l = new ArrayList<String>();
		l.add("7");
		l.add("8");
		l.add("9");
		l.add("10");
		l.add("11");
		return l;
	}


	public List<String> getListIdsProducto(int n) throws SQLException {
		List<String> lids = new ArrayList<String>();
		ConexionDb = ManagerMySql.getConnection();

		query = "SELECT  p.id_producto FROM Producto p limit " + n;
		sentenciaSql = ConexionDb.prepareStatement(query);
		ResultSet rsids = sentenciaSql.executeQuery();
		
		while (rsids.next()) {

			String id = rsids.getString("id_producto");
			lids.add(id);
		}
		return lids;
	}
	
	public Publicacion getPublicacionById(String id_publicacion) throws Exception {

		ConexionDb = ManagerMySql.getConnection();

		query = "SELECT  * FROM Publicacion p where id_publicacion="+ id_publicacion;
		sentenciaSql = ConexionDb.prepareStatement(query);
		ResultSet rspublicacion = sentenciaSql.executeQuery();
		
		Publicacion p = Publicacion.factoryPublicacion(rspublicacion);

		return p;
	}


	
	
	
}
