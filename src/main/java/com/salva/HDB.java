package com.salva;

import java.util.List;

import org.springframework.stereotype.Component;

import com.model.Caracteristica;
import com.model.Imagen;
import com.model.Publicacion;
import com.model.Vendedor;
@Component("HDB")
public class HDB implements IServiceDB {

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Publicacion> getPublicaciones(String id_vendedor, int cantidad) {
		// TODO Auto-generated method stub
		return null;
	}

}
