package com.lti.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.lti.dao.AnswerDao;
import com.lti.model.Answer;
import com.lti.model.Option;

public class AnswerService {

	@Autowired
	private AnswerDao answerDao;

	public void addAnswer(Answer answer){
		answerDao.save(answer);
	}

	public int checkAnswer(Set<Option> options, int option){
		for (Option checkOption : options) {
			if(checkOption.getCorrcetOption().equalsIgnoreCase("y"))
				if(checkOption.getOptionId()==option)
					return 2;
				else 
					return 0;
		}
		return 0;
	}
}
