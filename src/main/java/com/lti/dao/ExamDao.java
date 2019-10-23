package com.lti.dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.model.Exam;

@Repository
public class ExamDao extends GenericDao {

	@PersistenceContext
	public EntityManager entityManager;
	
	public Object fetchExam(int userId, int subjectId){
		
		String ql = "select e from Exam e where e.user.userID=:uId and e.subject.subjectId=:sub";
		Query q = entityManager.createQuery(ql);
		q.setParameter("uId",userId);
		q.setParameter("sub",subjectId);
		return q.getSingleResult();
		
	}
}
