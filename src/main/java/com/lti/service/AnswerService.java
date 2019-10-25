package com.lti.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.AnswerDao;
import com.lti.model.Answer;
import com.lti.model.Exam;
import com.lti.model.Option;
import com.lti.model.Question;

@Service
public class AnswerService {

	@Autowired
	private AnswerDao answerDao;


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

	public Answer fetchAnswerByQuestionAndExam(int examId, int questionId) {
		return (Answer) answerDao.fetchAnswerByQuestionAndExam(examId,questionId); 
	}


	public Answer getAnswer(Exam exam,Question question,int score,int option){
		
		Answer answer = new Answer();
		try{
			answer=(Answer) answerDao.fetchAnswerByQuestionAndExam(exam.getExamId(),question.getQuestionId());
		}catch (Exception e) {
			answer.setExamId(exam);
			answer.setQuestion(question);
			}
			answer.setScore(score);
			answer.setSelectedId(option);
			answer = (Answer) answerDao.save(answer);
			return answer;
	}
}
