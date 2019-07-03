package com.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.model.Caracteristica;
import com.model.Imagen;
import com.model.Producto;
import com.model.Publicacion;
import com.model.Vendedor;

@Component
@Qualifier("RepoHDB")
public class RepoHDB implements RepoObjetosInterface {

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
	public Vendedor getVendedorById(String id_vendedor) {
		// TODO Auto-generated method stub
		return this.getVendedor1();
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
	public List<Publicacion> getPublicacionesByIdVendedor(String idVendedor,
			int cantidad) {
		// TODO Auto-generated method stub
			
		return this.getVendedor1().publicaciones;
	}
	
	private Vendedor getVendedor1(){
		Vendedor vend1 = new Vendedor();
		vend1.id_vendedor = "1";
		vend1.nombre = "Daniel Chungara";
		vend1.ubicacion = "Monte Grande";
			//Publicacion 1
			Publicacion pub1 = new Publicacion();
			pub1.id_publicacion ="1";
			pub1.id_producto ="1";
			pub1.id_vendedor ="1";
			pub1.titulo="Oportunidad Oferta Buzo Peluche varios colores";
			pub1.vendedor = vend1;	
				Producto prod1 = new Producto();
				prod1.id_producto = "1";
				prod1.descripcion="Buzo Peluche nena 4-14";
				prod1.precio = "350";
					List<Caracteristica> lcar1 = new ArrayList<Caracteristica>();
					Caracteristica car1 = new Caracteristica();
					car1.id_caracteristica = "1";
					car1.id_producto = "1";
					car1.tipo = "Marca";
					car1.valor = "Tizal";
					Caracteristica car2 = new Caracteristica();
					car2.id_caracteristica = "2";
					car2.id_producto = "1";
					car2.tipo = "Talles";
					car2.valor = "4-6-8-10-12-14";
					lcar1.add(car1);
					lcar1.add(car2);
					
					List<Imagen> limg1 = new ArrayList<Imagen>();
					Imagen img1 = new Imagen();
					img1.id_imagen= "1";
					img1.id_producto = "1";
					img1.descripcion = "Buzo peluche";
					img1.url = "/products/buzo-peluche.webp";
					Imagen img2 = new Imagen();
					img2.id_imagen= "2";
					img2.id_producto = "1";
					img2.descripcion = "Buzo peluche";
					img2.url = "/products/buzo-peluche2.jpg";
					limg1.add(img1);
					limg1.add(img2);
				prod1.caracteristicas = lcar1;
				prod1.imagenes = limg1;
			pub1.producto = prod1;
			//Publicacion 2
			Publicacion pub2 = pub1;
			//Publicacion 3
			Publicacion pub3 = pub1;
			//Publicacion 4
			Publicacion pub4 = pub1;
			//Publicacion 5
			Publicacion pub5 = pub1;
			
			List<Publicacion> lpub1 = new ArrayList<Publicacion>();
				lpub1.add(pub1);
				lpub1.add(pub2);
				lpub1.add(pub3);
				lpub1.add(pub4);
				lpub1.add(pub5);

		vend1.publicaciones = lpub1;
		return vend1;
	}

}
