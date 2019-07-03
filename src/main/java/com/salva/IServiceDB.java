package com.salva;

import java.sql.SQLException;
import java.util.List;

import com.model.Caracteristica;
import com.model.Imagen;
import com.model.Publicacion;
import com.model.Vendedor;

public interface IServiceDB {

	public Publicacion getPublicacionById(String id_publicacion);

	public Publicacion getProductoById(String id_producto);

	public Vendedor getVendedorById(String id_vendedor);

	public List<Imagen> getImagenesByIdProducto(String id_producto);

	public List<Caracteristica> getCaracteristicasByIdProducto(String id_producto);

	public List<Publicacion> getPublicacionesByIdVededor(String id_vendedor);
	
	public List<Publicacion> getPublicaciones(int cantidad);
	
	public List<Publicacion> getPublicaciones(String id_vendedor, int cantidad) throws SQLException;


}