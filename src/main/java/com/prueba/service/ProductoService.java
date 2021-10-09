package com.prueba.service;

import java.util.Date;
import java.util.List;

import com.prueba.negocio.modelos.Producto;
import com.prueba.negocio.modelos.ProductoFinal;

public interface ProductoService {

	public List<Producto> getProductos();
	public ProductoFinal getProductoFinal(Date fechaAplicacion, Long idProducto, Long idCadena);
}
