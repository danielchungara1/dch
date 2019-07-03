/**************************************************
***************MODELO DE DATOS*********************
***************************************************/
/*drop database dch_db;*/
/*DB*/
CREATE DATABASE IF NOT EXISTS dch_db;
USE dch_db;

/*Tablas*/
CREATE table IF NOT EXISTS  Producto(
	id_producto int AUTO_INCREMENT,
    precio decimal,
    descripcion varchar(255),
    PRIMARY KEY (id_producto)
    
);

CREATE TABLE IF NOT EXISTS Vendedor(
  id_vendedor INT AUTO_INCREMENT,
  ubicacion VARCHAR(255),
  nombre VARCHAR(255),
  PRIMARY KEY (id_vendedor)
);

create table  IF NOT EXISTS Publicacion(
	id_publicacion int AUTO_INCREMENT,
    id_producto int,
    titulo varchar(255),
    PRIMARY KEY  (id_publicacion),
    CONSTRAINT  FK_IdProductoPublicacion
	FOREIGN KEY  (id_producto)   REFERENCES Producto(id_producto) 
);

DELIMITER $$
IF NOT EXISTS( (SELECT * FROM dch_db.COLUMNS WHERE TABLE_SCHEMA=DATABASE()
        AND COLUMN_NAME='id_vendedor' AND TABLE_NAME='Publicacion') ) THEN
			ALTER TABLE Publicacion
			ADD  id_vendedor int,
			ADD CONSTRAINT FK_idVendedor
			FOREIGN KEY(id_vendedor)
			REFERENCES Vendedor(id_vendedor);
END IF;
DELIMITER ;



create table  IF NOT EXISTS Imagen(
	id_imagen int auto_increment,
    url varchar(255),
    descripcion varchar(255),
    id_producto int,
    PRIMARY KEY (id_imagen),
    CONSTRAINT FK_IdProductoImagen
    foreign key (id_producto) references Producto(id_producto)
);
create table  IF NOT EXISTS Caracteristica(
	id_producto int,
    id_caracteristica int auto_increment,
    tipo varchar(64),
    valor varchar(255),
    PRIMARY KEY (id_caracteristica),
    CONSTRAINT FK_IdProducto
	foreign key (id_producto) references Producto(id_producto)
);
CREATE TABLE IF NOT EXISTS Vendedor(
  id_vendedor INT AUTO_INCREMENT,
  ubicacion VARCHAR(255),
  nombre VARCHAR(255),
  PRIMARY KEY (id_vendedor)
);



