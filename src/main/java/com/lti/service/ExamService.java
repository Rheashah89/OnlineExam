package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.ExamDao;
import com.lti.model.Exam;
import com.lti.model.Subject;
import com.lti.model.User;

@Service
public class ExamService {

	@Autowired
	private ExamDao examDao;
	
	public Exam fetchExam(User user, Subject subject){
		
		Exam exam = new Exam();
		try{
			exam = (Exam) examDao.fetchExam(user.getUserID(),subject.getSubjectId());
			}catch (Exception e) {
				exam.setSubject(subject);
				exam.setUser(user);
				exam.setCurrentLevel(1);
				exam.setNoOfAttempts(0);
				exam = (Exam) examDao.save(exam);
			}
		return exam;
			
	}

	public Exam save(Exam exam) {
		return (Exam)examDao.save(exam);
	}
}
