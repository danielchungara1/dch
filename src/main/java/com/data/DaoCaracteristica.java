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
 * @created 29-jun.-2019 10:24:37
 */
@Component
public class DaoCaracteristica {

	private String query;
	private ResultSet rSet;
	
	public DaoCaracteristica(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param id_producto
	 * @throws SQLException 
	 */
	public List<Caracteristica> getCaracteristicasByIdProducto(String id_producto) throws SQLException{
		query = "Select * from Caracteristica c where id_producto = " + id_producto;
		rSet = ManagerMySql.executeQuery(query);
		
		List<Caracteristica> lCaracteristicas = new ArrayList<Caracteristica>();
		while (rSet.next()) {
			Caracteristica car = new Caracteristica();
			car.id_caracteristica = rSet.getString("id_caracteristica");
			car.id_producto= rSet.getString("id_producto");
			car.tipo = rSet.getString("tipo");
			car.valor= rSet.getString("valor");
			lCaracteristicas.add(car);
		}
		
		return lCaracteristicas;
	}
}//end DaoCaracteristica