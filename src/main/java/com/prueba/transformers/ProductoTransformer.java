package com.prueba.transformers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.prueba.negocio.modelos.Cadena;
import com.prueba.negocio.modelos.Producto;
import com.prueba.persistencia.modelos.CadenaEntity;
import com.prueba.persistencia.modelos.ProductoEntity;

@Component
public class ProductoTransformer implements BaseTransformer<ProductoEntity, Producto>{

	@Override
	public Producto modelo2Negocio(ProductoEntity modelo) {
		Producto producto = new Producto();
		producto.setId(modelo.getId());
		
		Cadena cadena = new Cadena();
		cadena.setId(modelo.getCadena().getId());
		cadena.setNombre(modelo.getCadena().getNombre());
		producto.setCadena(cadena);
		
		producto.setCodigoProducto(modelo.getCodigoProducto());
		producto.setPrecio(modelo.getPrecio());
		producto.setFechaInicioAplicacion(modelo.getFechaInicioAplicacion());
		producto.setFechaFinAplicacion(modelo.getFechaFinAplicacion());
		producto.setMoneda(modelo.getMoneda());
		producto.setIdentificadorTarifa(modelo.getIdentificadorTarifa());
		producto.setPrioridad(modelo.getPrioridad());
		
		return producto;
	}

	@Override
	public ProductoEntity negocio2Modelo(Producto negocio) {
		ProductoEntity modelo = new ProductoEntity();
		modelo.setId(negocio.getId());
		
		CadenaEntity cadena = new CadenaEntity();
		cadena.setId(negocio.getCadena().getId());
		cadena.setNombre(negocio.getCadena().getNombre());
		modelo.setCadena(cadena);
		
		modelo.setCodigoProducto(negocio.getCodigoProducto());
		modelo.setPrecio(negocio.getPrecio());
		modelo.setFechaInicioAplicacion(negocio.getFechaInicioAplicacion());
		modelo.setFechaFinAplicacion(negocio.getFechaFinAplicacion());
		modelo.setMoneda(negocio.getMoneda());
		modelo.setIdentificadorTarifa(negocio.getIdentificadorTarifa());
		modelo.setPrioridad(negocio.getPrioridad());
		
		return modelo;
	}

	public List<Producto> modelos2Negocios(List<ProductoEntity> entities) {
		List<Producto> productos = new ArrayList<Producto>();
		if(entities != null && !entities.isEmpty()) {			
			entities.forEach(entity -> productos.add(modelo2Negocio(entity)));
		}
		return productos;
	}
	
	public List<ProductoEntity> negocios2Modelos(List<Producto> listaNegocio) {
		List<ProductoEntity> entities = new ArrayList<ProductoEntity>();
		if(listaNegocio != null && !listaNegocio.isEmpty()) {			
			listaNegocio.forEach(negocio -> entities.add(negocio2Modelo(negocio)));
		}
		return entities;
	}
	
}
