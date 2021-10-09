package com.prueba.dao;

import org.springframework.data.repository.CrudRepository;

import com.prueba.persistencia.modelos.CadenaEntity;

public interface CadenaDao extends CrudRepository<CadenaEntity, Long>{

}
