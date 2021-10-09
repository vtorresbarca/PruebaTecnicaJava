package com.prueba.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.dao.ProductoDao;
import com.prueba.negocio.modelos.Producto;
import com.prueba.negocio.modelos.ProductoFinal;
import com.prueba.persistencia.modelos.ProductoEntity;
import com.prueba.transformers.ProductoFinalTransformer;
import com.prueba.transformers.ProductoTransformer;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoDao productoDao;
	
	@Autowired
	private ProductoTransformer productoTransformer;

	@Autowired
	private ProductoFinalTransformer productoFinalTransformer;
	
	@Override
	@Transactional(readOnly = true)
	public ProductoFinal getProductoFinal(Date fechaAplicacion, Long idProducto, Long idCadena) {
		Producto producto = null;
		
		List<ProductoEntity> entities = productoDao.getProductoFinal(fechaAplicacion, idProducto, idCadena);
		if(entities != null && !entities.isEmpty()) {
			ProductoEntity maxEntity = Collections.max(entities, Comparator.comparing(e -> e.getPrioridad()));
			if(maxEntity != null) {
				producto = productoTransformer.modelo2Negocio(maxEntity);
			}
		}
		return productoFinalTransformer.transform2Bean(producto);
	}
	
//	private String formatDate(Date fecha) {
//		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> getProductos() {
		List<ProductoEntity> result = productoDao.getProductos();
		if(result != null) {
			return productoTransformer.modelos2Negocios(result);
		}
		return new ArrayList<Producto>();
	}
	
}
