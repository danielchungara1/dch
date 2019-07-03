package com.salva;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

import org.springframework.stereotype.Component;

import com.data.ManagerMySql;
import com.model.Caracteristica;
import com.model.Imagen;
import com.model.Publicacion;
import com.model.Vendedor;


@Component("MySqlDB")
public class MySqlDB implements IServiceDB {

	@Override
	public Publicacion getPublicacionById(String id_publicacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Publicacion getProductoById(String id_producto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vendedor getVendedorById(String id_vendedor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Imagen> getImagenesByIdProducto(String id_producto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Caracteristica> getCaracteristicasByIdProducto(
			String id_producto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Publicacion> getPublicacionesByIdVededor(String id_vendedor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Publicacion> getPublicaciones(int cantidad) {

		return null;
	}

	@Override
	public List<Publicacion> getPublicaciones(String id_vendedor, int cantidad) throws SQLException {
		// TODO Auto-generated method stub
		Connection ConexionDb = ManagerMySql.getConnection();

		String query = "SELECT  * FROM Publicacion p where id_vendedor="+ id_vendedor +" limit "+ cantidad ;
		PreparedStatement sentenciaSql = ConexionDb.prepareStatement(query);
		ResultSet rspublicacion = sentenciaSql.executeQuery();
		
		BuilderPublicacionMySql bp = new BuilderPublicacionMySql(rspublicacion);
		List<Publicacion> lp = bp.build();
		
		return lp;
	}
	
	


}//end MySqlDB