package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class AnswerDao extends GenericDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public Object fetchAnswerByQuestionAndExam(int examId, int questionId) {
		String ql = "select a from Answer a where a.exam.examId=:eId and a.question.questionId=:qId";
		Query q = entityManager.createQuery(ql);
		q.setParameter("eId",examId);
		q.setParameter("qId",questionId);
		return q.getSingleResult();
		
	}

}
