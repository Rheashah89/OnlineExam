package com.lti.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.model.Answer;
import com.lti.model.Exam;
import com.lti.model.Option;
import com.lti.model.Question;
import com.lti.model.User;

@Repository
public class AdminSearchDao {

	@PersistenceContext
	public EntityManager entityManager;



	public List<User> searchUsersByTechnology(String firstselect,String secondselect){
		int id = Integer.parseInt(secondselect);
		String ql = "select e from Exam e where e.subject.subjectId=:ss";
		Query q = entityManager.createQuery(ql);

		q.setParameter("ss",id);
		List<Exam> exams=q.getResultList();

		List<User> users = new ArrayList<User>();
		for (Exam exam : exams) {

			users.add(exam.getUser());
		}
		return users;

	}


	public List<User> searchUsers(String firstselect,String secondselect){

		String ql = "select u from User u where u."+firstselect+"=:ss";
		Query q = entityManager.createQuery(ql);
		//q.setParameter("fs",firstselect);
		q.setParameter("ss",secondselect);

		return q.getResultList();

	}



	public List<Exam> searchUsersById(int studentId){

		String ql = "select e from Exam e where e.user.userID=:sn";
		Query q = entityManager.createQuery(ql);

		q.setParameter("sn",studentId);

		return q.getResultList();

	}
	
	public List<Question> viewReportBySubjectNameAndEmail(int examId){

		String ql = "select distinct q from Answer a join a.exam e join a.question q join fetch q.options o where e.examId=:sn" ;
		Query q = entityManager.createQuery(ql);

		q.setParameter("sn",examId);
		
		//join fetch q.Option o
		
		String ql1= "select a.selectedId from Answer a where a.exam.examId=:sn";
		Query q1 = entityManager.createQuery(ql1);

		q1.setParameter("sn",examId);
		//list of answers selected by user
		List<Integer> list=  q1.getResultList();
		
		//list of questions the user gave the exam
		List<Question> questions= q.getResultList();
			 
		for(Question ques :questions){
			for(Option opt: ques.getOptions()){
				if(list.contains(opt.getOptionId())){
					opt.setSelected(true);
				}
			}
		}
		
		return questions;
		
	}
	
	
	public List<Question> removeQuestion(int subjectId, int level){

		String ql = "select q from Question q where q.subject.subjectId=:sn and q.questionLevel=:le" ;
		Query q = entityManager.createQuery(ql);

		q.setParameter("sn",subjectId);
		q.setParameter("le",level);
		return q.getResultList();
		
		
	}


	public void removeQuestionById(int questionId) {
		
		String ql = "delete q from Question q where q.questionId=:sn" ;
		Query q = entityManager.createQuery(ql);

		q.setParameter("sn",questionId);
	}
}
