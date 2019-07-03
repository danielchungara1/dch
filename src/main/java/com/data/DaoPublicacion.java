package com.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.model.*;



/**
 * @author DANIEL CH
 * @version 1.0
 * @created 29-jun.-2019 10:24:32
 */
@Component
public class DaoPublicacion {

	@Autowired
	public DaoProducto dProducto;
	
	@Autowired
	public DaoVendedor dVendedor;
	
	public ResultSet resultSet;
	public String query;

	

	public DaoPublicacion(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param id_publicacion
	 */
	public Publicacion getPublicacionById(String id_publicacion){
		return null;
	}

	public  List<Publicacion> getPublicacionesByVendedor(Vendedor vend) throws SQLException {
		// TODO Auto-generated method stub
		
		query = "Select * from Publicacion p where id_vendedor = " + vend.id_vendedor;
		resultSet = ManagerMySql.executeQuery(query);
		
		List<Publicacion> lPublicaciones = new ArrayList<Publicacion>();
		while (resultSet.next()) {
			Publicacion pub = new Publicacion();
			
			pub.id_publicacion = resultSet.getString("id_publicacion");
			pub.id_producto = resultSet.getString("id_producto");
			pub.id_vendedor = resultSet.getString("id_vendedor");
			pub.titulo = resultSet.getString("titulo");
			pub.vendedor = vend;
			pub.producto = dProducto.getProductoById(pub.id_producto);
			
			lPublicaciones.add(pub);
		}
		return lPublicaciones;
		
	}

	public List<Publicacion> getPublicacionesByIdVendedor(String id_vendedor,
			int cantidad) throws SQLException {
		// TODO Auto-generated method stub
		Vendedor vend = dVendedor.getVendedorById(id_vendedor);
		List<Publicacion> publicacionesFiltered = vend.getPublicaciones(cantidad);
		
		return publicacionesFiltered;
	}
}//end DaoPublicacion