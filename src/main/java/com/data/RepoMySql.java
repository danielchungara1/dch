package com.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.model.Caracteristica;
import com.model.Imagen;
import com.model.Publicacion;
import com.model.Vendedor;


@Component
@Qualifier("RepoMySql")
public class RepoMySql implements RepoObjetosInterface {
	
	Connection connection;
	PreparedStatement  sentenciaSql;
	String query;
	ResultSet resultSet;
	
	@Autowired
	DaoVendedor dVendedor;
	@Autowired
	DaoPublicacion dPublicacion ;
	
	public RepoMySql() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Publicacion getPublicacionById(String id_publicacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Publicacion> getPublicacionesByIdVendedor(String id_vendedor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Publicacion getProductoById(String id_producto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vendedor getVendedorById(String id_vendedor) throws SQLException {
		// TODO Auto-generated method stub
		return dVendedor.getVendedorById(id_vendedor);
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
	public List<Publicacion> getPublicaciones(int cant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Publicacion> getPublicacionesByIdVendedor(String id_vendedor,
			int cantidad) throws SQLException {
		
		List<Publicacion> publicacionesFiltered = dPublicacion.getPublicacionesByIdVendedor(id_vendedor, cantidad);
		
		return publicacionesFiltered;
	}

}
