package com.prueba.transformers;

public interface BaseBeanTransformer<T,P> {

	public T transform2Bean(P negocio);
}
