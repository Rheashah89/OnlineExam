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
	
	public List<Answer> viewReportBySubjectNameAndEmail(int examId){

		String ql = "select a from Answer a where a.exam.examId=:sn";
		Query q = entityManager.createQuery(ql);

		q.setParameter("sn",examId);

		return q.getResultList();
		
		
	}
}
