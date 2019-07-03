					package com.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Vendedor {
	public String id_vendedor;
	public String ubicacion;
	public String nombre;
	public List<Publicacion> publicaciones;
	
	public List<Publicacion> getPublicaciones(int cantidad) {
		// TODO Auto-generated method stub
		Iterator<Publicacion> iterador = this.publicaciones.iterator();
		int contador = 0;
		List<Publicacion> publicacionesFiltered = new ArrayList<Publicacion>();
		while (iterador.hasNext() && contador < cantidad) {
			Publicacion publicacion = (Publicacion) iterador.next();
			
			publicacionesFiltered.add(publicacion);
			
			contador++;
			
		}
		return publicacionesFiltered;
	}

	public Publicacion getPublicacion(String id_publicacion) {
		// TODO Auto-generated method stub

		return this.publicaciones.stream().filter(pub -> pub.id_publicacion.equals( id_publicacion)).collect(Collectors.toList()).get(0);
		
	}
}
