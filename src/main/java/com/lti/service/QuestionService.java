package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.QuestionDao;
import com.lti.model.Question;

@Service
public class QuestionService {

	@Autowired
	private QuestionDao questionDao;
	
	public List<Question> fetchQuestions(int subjectId,int currentLevel){
		return questionDao.fetchQuestions(subjectId,currentLevel);
	}
}
