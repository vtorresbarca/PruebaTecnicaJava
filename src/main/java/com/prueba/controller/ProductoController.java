package com.prueba.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.negocio.modelos.Producto;
import com.prueba.negocio.modelos.ProductoFinal;
import com.prueba.service.ProductoService;

@RestController
@RequestMapping(value = "tienda")
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	

	@GetMapping(value = "/productos")
	public ResponseEntity<List<Producto>> getProductos() {
		List<Producto> productos = productoService.getProductos();
		if(productos != null) {
			return new ResponseEntity<List<Producto>>(productos, HttpStatus.OK);
		}
		return new ResponseEntity<List<Producto>>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping(value = "/producto/{fechaAplicacion}/{idProducto}/{idCadena}")
	public ResponseEntity<ProductoFinal> getProductoFinal(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")Date fechaAplicacion, 
										  @PathVariable("idProducto") Long idProducto, 
										  @PathVariable("idCadena") Long idCadena) {

		if(fechaAplicacion == null || idProducto == null || idProducto == 0 || idCadena == null || idCadena == 0) {
			return new ResponseEntity<ProductoFinal>(HttpStatus.BAD_REQUEST);
			
		}else {
			ProductoFinal producto = productoService.getProductoFinal(fechaAplicacion, idProducto, idCadena);
			if(producto != null) {
				return new ResponseEntity<ProductoFinal>(producto, HttpStatus.OK);
			}
		}
		return new ResponseEntity<ProductoFinal>(HttpStatus.BAD_REQUEST);
	}
	
}
