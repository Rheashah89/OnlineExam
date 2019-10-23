package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.model.Subject;
import com.lti.model.User;

@Repository
public class RetriveSubjectDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Subject> fetchAll(){
		
		String ql = "select s from Subject s";
		Query q = entityManager.createQuery(ql);
		
		return q.getResultList();
	}
	
}
