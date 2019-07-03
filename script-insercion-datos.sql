/**************************************************
***************TEST INSERCION DATOS****************
***************************************************/

use dch_db;

/**************************************************
1-Producto Calza
***************************************************/
INSERT INTO  Producto( descripcion, precio)
	values
    ("Calza termica", 290);
set @id_producto = LAST_INSERT_ID();
/*Imagen*/
INSERT INTO Imagen (url, descripcion, id_producto)
	values
    ("https://http2.mlstatic.com/calzas-termicas-estampadas-nena-talle-del-4-al-14-D_NQ_NP_680612-MLA29797188280_032019-F.webp","calza termica", @id_producto);
/*Producto caracteristica*/
Insert into Caracteristica(tipo, valor, id_producto)
	values
   ( "Marca", "Otra", @id_producto),
   ("Modelo","Calza frizada", @id_producto);
insert into Publicacion(id_producto, titulo)
	values
    (@id_producto, "Calzas Térmicas Estampadas Nena!!! Talle Del 4 Al 14");
    
/**************************************************
2-Productos buzo peluche
***************************************************/
INSERT INTO  Producto( descripcion, precio)
	values
    ("Buzo peluche cara osito", 460);
set @id_producto = LAST_INSERT_ID();
/*Imagen*/
INSERT INTO Imagen (url, descripcion, id_producto)
	values
    ("https://http2.mlstatic.com/buzos-capucha-nena-2-al-14-oso-abrigado-peluche-2018-D_NQ_NP_934562-MLA27543442907_062018-F.webp","buzo peluche", @id_producto);
INSERT INTO Imagen(url, descripcion, id_producto)
	values
    ("https://http2.mlstatic.com/buzo-peluche-dibujo-oso-con-capucha-y-orejitas-nena-kawai-D_NQ_NP_626581-MLA29935555089_042019-F.webp","buzos peluche varios colres",@id_producto);
/*Producto caracteristica*/
Insert into Caracteristica(tipo, valor, id_producto)
	values
   ( "Marca", "Tiza", @id_producto),
   ("Modelo","Osito", @id_producto);
insert into Publicacion(id_producto, titulo)
	values
    (@id_producto, "Buzos Capucha Nena 2 Al 14 Oso Abrigado Peluche 2018");
/**************************************************
3-Productos buzo camuflado friza niño
***************************************************/
INSERT INTO  Producto( descripcion, precio)
	values
    ("Buzo camuflado invisible", 290);
set @id_producto = LAST_INSERT_ID();
/*Imagen*/
INSERT INTO Imagen (url, descripcion, id_producto)
	values
    ("https://http2.mlstatic.com/buzo-canguro-gap-nino-original-D_NQ_NP_954557-MLA29819839462_042019-O.webp","buzo camuflado", @id_producto);
/*Producto caracteristica*/
Insert into Caracteristica(tipo, valor, id_producto)
	values
   ( "Marca", "GAP", @id_producto),
   ("Modelo","Canguro de Friza", @id_producto);
insert into Publicacion(id_producto, titulo)
	values
    (@id_producto, "Buzo Canguro Gap Niño Original");   
/**************************************************
4-Productos buzo friza niño
***************************************************/
INSERT INTO  Producto( descripcion, precio)
	values
    ("Buzo friza invisible", 250);
set @id_producto = LAST_INSERT_ID();
/*Imagen*/
INSERT INTO Imagen (url, descripcion, id_producto)
	values
    ("https://http2.mlstatic.com/buzo-canguro-liso-ninos-invisible-peinado-excelente-D_NQ_NP_739585-MLA27067234193_032018-F.webp","buzo invisble liso", @id_producto);
/*Producto caracteristica*/
Insert into Caracteristica(tipo, valor, id_producto)
	values
   ( "Marca", "Fabrica", @id_producto),
   ("Modelo","Canguro", @id_producto);
insert into Publicacion(id_producto, titulo)
	values
    (@id_producto, "Buzo Canguro Liso Niños Invisible Peinado Excelente!!");   
/**************************************************
5-Producto pantalon joggin friza niño
***************************************************/
INSERT INTO  Producto( descripcion, precio)
	values
    ("Pantalon joggin niño friza", 200);
set @id_producto = LAST_INSERT_ID();
/*Imagen*/
INSERT INTO Imagen (url, descripcion, id_producto)
	values
    ("https://http2.mlstatic.com/pack-x3-pantalon-joggins-puno-de-friza-varon-4-al-16-D_NQ_NP_943240-MLA30571869835_052019-F.webp","Pantalon joggin liso", @id_producto);
/*Producto caracteristica*/
Insert into Caracteristica(tipo, valor, id_producto)
	values
   ( "Marca", "Amuko", @id_producto),
   ("Modelo","Joggin con puño", @id_producto);
insert into Publicacion(id_producto, titulo)
	values
    (@id_producto, "Pack X3 Pantalon Joggins Puño De Friza Varon 4 Al 16");  



