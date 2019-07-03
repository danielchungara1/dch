package com.data;

import com.model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


/**
 * @author DANIEL CH
 * @version 1.0
 * @created 29-jun.-2019 10:24:36
 */
@Component
public class DaoImagen {

	private String query;
	private ResultSet rSet;
	
	public DaoImagen(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param id_producto
	 * @throws SQLException 
	 */
	public List<Imagen> getImagenesByIdProducto(String id_producto) throws SQLException{
		query = "Select * from Imagen i where id_producto = " + id_producto;
		rSet = ManagerMySql.executeQuery(query);
		
		List<Imagen> lImagenes= new ArrayList<Imagen>();
		while (rSet.next()) {
			Imagen img = new Imagen();
			img.id_imagen= rSet.getString("id_imagen");
			img.id_producto= rSet.getString("id_producto");
			img.descripcion = rSet.getString("descripcion");
			img.url = rSet.getString("url");
			lImagenes.add(img);
		}
		
		return lImagenes;
	}
}//end DaoImagen