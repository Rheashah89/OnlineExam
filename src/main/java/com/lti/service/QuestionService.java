package com.lti.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
		Map<Integer, Question> finalQuestions = new HashMap<Integer, Question>(10);
		
		Random rand = new Random();
	 
	    int numberOfElements = 10;
	 
	    for (int i = 0; i <numberOfElements; i++) {
	        int randomIndex = rand.nextInt(listOfquestions.size());
	        Question randomElement = listOfquestions.get(randomIndex);
	        listOfquestions.remove(randomIndex);
	        finalQuestions.put(i,randomElement);
	    }
		return finalQuestions;
	}
	
	
}
