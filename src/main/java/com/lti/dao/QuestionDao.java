package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.model.Question;

@Repository
public class QuestionDao extends GenericDao {

	@PersistenceContext
	public EntityManager entityManager;
	
	public List<Question> fetchQuestions(int subjectId,int currentLevel){
		
		String ql = "select q from Question q where q.subject.subjectId=:subId and q.questionLevel=:level";
		Query q = entityManager.createQuery(ql);
		q.setParameter("subId",subjectId);
		q.setParameter("level",currentLevel);
		
		return q.getResultList();
		
	}
}
