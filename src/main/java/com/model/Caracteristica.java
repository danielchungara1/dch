package com.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Caracteristica {
	public String tipo;
	public String valor;
	public String id_caracteristica;
	public String id_producto;
	
	/*************************DEPRECADO***************************/
	@Deprecated
	public static List<Caracteristica> factoryCaracteristicas(ResultSet rscaracteristicas) throws SQLException {
		List<Caracteristica> lc = new ArrayList<Caracteristica>();
		while (rscaracteristicas.next()) {
			Caracteristica c = new Caracteristica();
			c.tipo = rscaracteristicas.getString("tipo");
			c.valor = rscaracteristicas.getString("valor");
			lc.add(c);
		}
		return lc;
	}
	
}
