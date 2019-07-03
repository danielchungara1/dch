package com.model;

import java.sql.ResultSet;
import com.salva.ServiceBD;


public class Publicacion {
	public String id_publicacion;
	public String id_vendedor;
	public String id_producto;
	public String titulo;
	
	//Dependecias
	public Producto producto;
	public Vendedor vendedor;

	/*************************DEPRECADO***************************/
	@Deprecated
	public static Publicacion factoryPublicacion(ResultSet rspublicacion) throws Exception {
		Publicacion p = new Publicacion();
		while (rspublicacion.next()) {
			p.id_publicacion = rspublicacion.getString("id_publicacion");
			p.titulo = rspublicacion.getString("titulo");
			p.id_vendedor =rspublicacion.getString("id_vendedor");
			p.id_producto = rspublicacion.getString("id_producto");
		}
		//Depencias
		ServiceBD serviceBD = new ServiceBD();
		p.producto = serviceBD.getProductoById(p.id_producto);
		//p.vendedor = serviceBD.getVendedorById(p.id_vendedor);
		
		return p;
	}

}
