package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository

public class GenericDao{

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void save(Object object){
		entityManager.persist(object);
	}
}

