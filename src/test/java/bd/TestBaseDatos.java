package bd;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import com.example.BaseDatos;

public class TestBaseDatos {

	Connection ConexionDb;
	String query;
	PreparedStatement sentenciaSql;
	ResultSet rs;

	@Before
	public void setUp() throws Exception {
		// Instancias la clase que hemos creado anteriormente
		BaseDatos db = new BaseDatos();
		// Llamas al método que tiene la clase y te devuelve una conexión
		ConexionDb = db.conectarMySQL();
		System.out.println("******************************");
		System.out.println("Test");
		System.out.println("******************************");
	}

	@Test
	public void testSelectProductos() throws Exception {

		// Query que usarás para hacer lo que necesites
		query = "SELECT * FROM Producto";

		// PreparedStatement
		sentenciaSql = ConexionDb.prepareStatement(query);
		// execute select SQL stetement
		rs = sentenciaSql.executeQuery();

		while (rs.next()) {

			String id_producto = rs.getString("id_producto");
			String descripcion_producto = rs.getString("descripcion");

			assertThat(id_producto, Matchers.notNullValue());
			assertThat(descripcion_producto, Matchers.notNullValue());

			System.out.println(id_producto + "|" + descripcion_producto);

		}
	}// fint test

	// SELECT p.precio, i.url FROM Producto p, Imagen i limit 1;
	@Test
	public void testSelectPrecioImagenUnProducto() throws Exception {
		query = "SELECT  p.precio, i.url FROM Producto p, Imagen i limit 1";
		sentenciaSql = ConexionDb.prepareStatement(query);
		rs = sentenciaSql.executeQuery();

		while (rs.next()) {

			String precio = rs.getString("precio");
			String url = rs.getString("url");

			assertThat(precio, Matchers.notNullValue());
			assertThat(url, Matchers.notNullValue());

			System.out.println(precio + "|" + url);

		}

	}// fin test
		// SELECT p.precio, i.url FROM Producto p, Imagen i limit 5;

	@Test
	public void testSelectPrecioImagen5Productos() throws Exception {
		query = "SELECT  p.precio, i.url FROM Producto p, Imagen i limit 5";
		sentenciaSql = ConexionDb.prepareStatement(query);
		rs = sentenciaSql.executeQuery();

		while (rs.next()) {

			String precio = rs.getString("precio");
			String url = rs.getString("url");

			assertThat(precio, Matchers.notNullValue());
			assertThat(url, Matchers.notNullValue());

			System.out.println(precio + "|" + url);

		}

	}// fin test

	// SELECT p.precio, i.url FROM Producto p, Imagen i limit n;
	@Test
	public void testSelectPrecioImagenNProductos() throws Exception {
		int n = 4;
		query = "SELECT  p.precio, i.url FROM Producto p, Imagen i limit " + n;
		sentenciaSql = ConexionDb.prepareStatement(query);
		rs = sentenciaSql.executeQuery();

		while (rs.next()) {

			String precio = rs.getString("precio");
			String url = rs.getString("url");

			assertThat(precio, Matchers.notNullValue());
			assertThat(url, Matchers.notNullValue());

			System.out.println(precio + "|" + url);

		}

	}// fin test
	


}
