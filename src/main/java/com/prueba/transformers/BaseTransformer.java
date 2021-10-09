package com.prueba.transformers;

public interface BaseTransformer<M, N> {

	public N modelo2Negocio(M modelo);
	
	public M negocio2Modelo(N negocio);
	
}
