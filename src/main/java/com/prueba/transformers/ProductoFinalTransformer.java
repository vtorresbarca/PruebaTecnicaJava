package com.prueba.transformers;

import org.springframework.stereotype.Component;

import com.prueba.negocio.modelos.Producto;
import com.prueba.negocio.modelos.ProductoFinal;

@Component
public class ProductoFinalTransformer implements BaseBeanTransformer<ProductoFinal, Producto>{

	@Override
	public ProductoFinal transform2Bean(Producto negocio) {
		ProductoFinal bean = new ProductoFinal();
		if(negocio != null) {
			bean.setFechaInicioAplicacion(negocio.getFechaInicioAplicacion());
			bean.setFechaFinAplicacion(negocio.getFechaFinAplicacion());
			bean.setIdCadena(negocio.getCadena().getId());
			bean.setIdTarifaAplicar(negocio.getIdentificadorTarifa());
			bean.setPrecioFinal(negocio.getPrecio());
			bean.setCodigoProducto(negocio.getCodigoProducto());
		}
		
		return bean;
	}

}
