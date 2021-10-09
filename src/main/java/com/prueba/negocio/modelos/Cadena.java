package com.prueba.negocio.modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cadena implements Serializable {

	private static final long serialVersionUID = 6426910046483913911L;

	private Long id;
	
	private String nombre;
	
	private List<Producto> productos;

	public Cadena() {
		productos = new ArrayList<Producto>();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
}
