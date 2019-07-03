/**************************************************
***************Stored Procedures*******************
***************************************************/
delimiter $$
DROP procedure IF exists SP_EliminarProducto;
CREATE PROCEDURE `SP_EliminarProducto`(id_producto int)
BEGIN
   /*Eliminar Fotos Caracteristicas Publicacion*/
   delete from Imagen i where  i.id_producto = id_producto;
   delete from Caracteristica c where c.id_producto = id_producto;
   delete from Publicacion p where p.id_producto = id_producto;
   /*Eliminar producto propiamente dicho*/
   delete from Producto p where p.id_producto = id_producto;
END ;

/*CALL SP_EliminarProducto(1);*/


 use dch_db;
 select p.id_producto from Producto p; 	