package com.prueba.dao;

import java.util.Date;
import java.util.List;

import com.prueba.persistencia.modelos.ProductoEntity;

public interface ProductoDao {

	/**
	 * Recupera todos los productos del sistema
	 * */
	public List<ProductoEntity> getProductos();
	
	/**
	 * Devuelve un producto que cumpla con los parámetros de entrada
	 * */
	public List<ProductoEntity> getProductoFinal(Date fechaAplicacion, Long idProducto, Long idCadena);
}
