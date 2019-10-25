package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class ReportDao extends GenericDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	public Object fetchByExamId(int examId){
		
		String ql = "select r from Report r where r.exam.examId=:eId";
		Query q = entityManager.createQuery(ql);
		q.setParameter("eId",examId);
		return q.getSingleResult();
		
	}
}
