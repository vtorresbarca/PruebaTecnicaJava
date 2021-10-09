package com.prueba.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.prueba.persistencia.modelos.ProductoEntity;

@Repository
public class ProductoDaoImpl implements ProductoDao {

	@Autowired
	@Qualifier("session")
	private Session session;
	
	@Override
	public List<ProductoEntity> getProductoFinal(Date fechaAplicacion, Long codigoProducto, Long idCadena) {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<ProductoEntity> query = builder.createQuery(ProductoEntity.class);
		Root<ProductoEntity> root = query.from(ProductoEntity.class);
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if(codigoProducto != null && codigoProducto != 0) {
			predicates.add(builder.equal(root.get("codigoProducto"), codigoProducto));
		}
		
		if(idCadena != null && idCadena != 0) {
			predicates.add(builder.equal(root.get("cadena").get("id"), idCadena));
		}
		
		if(fechaAplicacion != null) {
			predicates.add(builder.between(builder.literal(fechaAplicacion), root.get("fechaInicioAplicacion"), root.get("fechaFinAplicacion")));
		}
		
		query.select(root).where(predicates.toArray(new Predicate[] {}));
		
		return session.createQuery(query).getResultList();
	}

	@Override
	public List<ProductoEntity> getProductos() {

		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<ProductoEntity> query = builder.createQuery(ProductoEntity.class);
		Root<ProductoEntity> root = query.from(ProductoEntity.class);
		query.select(root);
		
		return session.createQuery(query).getResultList();
	}

}
