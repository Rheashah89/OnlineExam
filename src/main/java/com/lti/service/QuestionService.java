package com.lti.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.QuestionDao;
import com.lti.model.Question;

@Service
public class QuestionService {

	@Autowired
	private QuestionDao questionDao;
	
	public Map<Integer,Question> fetchQuestions(int subjectId,int currentLevel){
		List<Question> listOfquestions= questionDao.fetchQuestions(subjectId,currentLevel);
		Map<Integer, Question> questions = new HashMap<Integer, Question>();
		for (int i = 0; i < listOfquestions.size(); i++) {
			questions.put(i+1,listOfquestions.get(i));
		}
		
		return questions;
	}
}
