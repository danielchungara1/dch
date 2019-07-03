package com.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.model.*;



/**
 * @author DANIEL CH
 * @version 1.0
 * @created 29-jun.-2019 10:24:33
 */
@Component
public class DaoProducto {
	
	@Autowired
	public DaoImagen dImagen;
	@Autowired
	public DaoCaracteristica dCaracteristica;
	
	private String query;
	private ResultSet resultSet;
	private Producto prod;
	
	public DaoProducto(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param id_producto
	 * @throws SQLException 
	 */
	public Producto getProductoById(String id_producto) throws SQLException{
		query = "Select * from Producto p where id_producto = " + id_producto;
		resultSet = ManagerMySql.executeQuery(query);
		
		prod = new Producto();
		while (resultSet.next()) {
			prod.id_producto = resultSet.getString("id_producto");
			prod.descripcion = resultSet.getString("descripcion");
			prod.precio = resultSet.getString("precio");
			prod.caracteristicas = dCaracteristica.getCaracteristicasByIdProducto(prod.id_producto);
			prod.imagenes = dImagen.getImagenesByIdProducto(prod.id_producto);
			
		}
		
		return prod;
	}
	 
}//end DaoProducto