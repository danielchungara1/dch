	
DROP DATABASE IF EXISTS dch_db;

CREATE DATABASE dch_db;
USE dch_db;
CREATE table  PRODUCTO(
	id_producto int primary key AUTO_INCREMENT,
    cod_caracteristica varchar(64),
    id_imagen int,
    precio decimal,
    descripcion varchar(255)
);

create table PUBLICACION(
	id_publicacion int primary key AUTO_INCREMENT,
    id_producto int,
    titulo varchar(255)
);

create table IMAGEN(
	id_image int primary key auto_increment,
    url varchar(255),
    descripcion varchar(255)
);

create table CARACTERISTICA(
	cod_caracteristica varchar(64),
	val_caracteristica varchar(255),
    PRIMARY KEY (cod_caracteristica, val_caracteristica)
);

create table PRODUCTO_CARACTERISTICA(
	id_producto int,
    cod_caracteristica varchar(64),
	primary key (id_producto, cod_caracteristica)
);


