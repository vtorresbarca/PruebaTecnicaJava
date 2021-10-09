package com.prueba.transformers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.prueba.negocio.modelos.Cadena;
import com.prueba.negocio.modelos.Producto;
import com.prueba.persistencia.modelos.CadenaEntity;
import com.prueba.persistencia.modelos.ProductoEntity;

@Component
public class CadenaTransformer implements BaseTransformer<CadenaEntity, Cadena>{

	@Override
	public Cadena modelo2Negocio(CadenaEntity modelo) {
		Cadena cadena = new Cadena();
		cadena.setId(modelo.getId());
		cadena.setNombre(modelo.getNombre());
		
		List<Producto> productos = modelo.getProductos().stream().map(entity -> {
			Producto producto = new Producto();
			producto.setId(entity.getId());
			producto.setCadena(cadena);
			producto.setCodigoProducto(entity.getCodigoProducto());
			producto.setPrecio(entity.getPrecio());
			producto.setFechaInicioAplicacion(entity.getFechaInicioAplicacion());
			producto.setFechaFinAplicacion(entity.getFechaFinAplicacion());
			producto.setMoneda(entity.getMoneda());
			producto.setIdentificadorTarifa(entity.getIdentificadorTarifa());
			producto.setPrioridad(entity.getPrioridad());
						
			return producto;
		}).collect(Collectors.toList());		
		cadena.setProductos(productos);
		
		return cadena;
	}

	@Override
	public CadenaEntity negocio2Modelo(Cadena negocio) {
		CadenaEntity entity = new CadenaEntity();
		entity.setId(negocio.getId());
		entity.setNombre(negocio.getNombre());
		
		List<ProductoEntity> productosEntity = negocio.getProductos().stream().map(producto -> {
			ProductoEntity productoEntity = new ProductoEntity();
			productoEntity.setId(producto.getId());
			productoEntity.setCadena(entity);
			productoEntity.setCodigoProducto(producto.getCodigoProducto());
			productoEntity.setPrecio(producto.getPrecio());
			productoEntity.setFechaInicioAplicacion(producto.getFechaInicioAplicacion());
			productoEntity.setFechaFinAplicacion(producto.getFechaFinAplicacion());
			productoEntity.setMoneda(producto.getMoneda());
			productoEntity.setIdentificadorTarifa(producto.getIdentificadorTarifa());
			productoEntity.setPrioridad(producto.getPrioridad());
			
			return productoEntity;
		}).collect(Collectors.toList());	

		entity.setProductos(productosEntity);
		
		return entity;
	}

}
