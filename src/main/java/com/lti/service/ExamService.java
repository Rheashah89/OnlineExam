package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.ExamDao;
import com.lti.model.Exam;

@Service
public class ExamService {

	@Autowired
	private ExamDao examDao;
	
	public Exam fetchExam(int userId){
		return (Exam) examDao.fetchExam(userId);
			
	}
}
