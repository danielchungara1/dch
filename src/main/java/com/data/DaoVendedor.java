package com.data;

import java.sql.ResultSet;
import java.sql.SQLException;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.model.*;



/**
 * @author DANIEL CH
 * @version 1.0
 * @created 29-jun.-2019 10:24:35
 */
@Component
public class DaoVendedor {

	public String query;
	public ResultSet resultSet;
	
	@Autowired
	public DaoPublicacion dPublicacion;
	
	public DaoVendedor(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param publicacion
	 */
	public Vendedor getVendedorByPublicacion(Publicacion publicacion){
		return null;
	}

	/**
	 * 
	 * @param id_vendedor
	 * @throws SQLException 
	 */
	public Vendedor getVendedorById(String id_vendedor) throws SQLException{
		
		query = "SELECT  * FROM Vendedor v where id_vendedor="+ id_vendedor;
		resultSet = ManagerMySql.executeQuery(query);
		
		Vendedor vend = new Vendedor();
		while (resultSet.next()) {
			vend.id_vendedor = resultSet.getString("id_vendedor");
			vend.ubicacion = resultSet.getString("ubicacion");
			vend.nombre = resultSet.getString("nombre");
			vend.publicaciones = dPublicacion.getPublicacionesByVendedor(vend);
		}
		
		
		return vend;
	}

	
}//end DaoVendedor