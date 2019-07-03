package com.data;
import com.model.*;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Component;


/**
 * @author DANIEL CH
 * @version 1.0
 * @created 29-jun.-2019 10:18:58
 */
@Component
public interface RepoObjetosInterface {

	/**
	 * 
	 * @param id_publicacion
	 */
	public Publicacion getPublicacionById(String id_publicacion);

	/**
	 * 
	 * @param id_vendedor
	 */
	public List<Publicacion> getPublicacionesByIdVendedor(String id_vendedor);

	/**
	 * 
	 * @param id_producto
	 */
	public Publicacion getProductoById(String id_producto);

	/**
	 * 
	 * @param id_vendedor
	 * @throws SQLException 
	 */
	public Vendedor getVendedorById(String id_vendedor) throws SQLException;

	/**
	 * 
	 * @param id_producto
	 */
	public List<Imagen> getImagenesByIdProducto(String id_producto);

	/**
	 * 
	 * @param id_producto
	 */
	public List<Caracteristica> getCaracteristicasByIdProducto(String id_producto);

	/**
	 * 
	 * @param cant
	 */
	public List<Publicacion> getPublicaciones(int cant);

	/**
	 * 
	 * @param id_vendedor
	 * @param cantidad
	 * @throws SQLException 
	 */
	public List<Publicacion> getPublicacionesByIdVendedor(String idVendedor, int cantidad) throws SQLException;

}