package com.lti.dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.model.Exam;

@Repository
public class ExamDao {

	@PersistenceContext
	public EntityManager entityManager;
	
	public Object fetchExam(int userId){
		
		String ql = "select e from Exam e where e.user=:tp";
		Query q = entityManager.createQuery(ql);
		q.setParameter("tp",userId);
		
		return q.getSingleResult();
		
	}
}
