package com.emergya.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.emergya.model.entitys.Sismo;

public interface ISismoDao extends CrudRepository<Sismo, Long> {

}
