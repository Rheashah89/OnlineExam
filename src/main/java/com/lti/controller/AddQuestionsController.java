package com.lti.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lti.dao.QuestionDao;
import com.lti.model.Option;
import com.lti.model.Question;
import com.lti.model.Subject;
import com.lti.service.AddQuestionsServiceInterface;

@Controller
public class AddQuestionsController {

	@Autowired
	AddQuestionsServiceInterface addQuestionsServiceInterface;
	
	@Autowired
	QuestionDao questionDao;

	@RequestMapping(path = "/addQuestionsWithFile.lti", method = RequestMethod.POST)
	public void addQuestionsWithFile() {
		LinkedHashMap<Integer, ArrayList<ArrayList<String>>> data = addQuestionsServiceInterface.addQuestionsUsingFile();
		
		for (Map.Entry<Integer, ArrayList<ArrayList<String>>> entry : data.entrySet()) {
			//System.out.println("Key = " + entry.getKey());
			ArrayList<ArrayList<String>> listOfQuestions = entry.getValue();
			for (ArrayList<String> questionAndOptions : listOfQuestions) {
				Object[] temp = questionAndOptions.toArray();
				
					Subject subject = new Subject();
					subject.setSubjectId(Integer.parseInt((String) temp[0]));
					
					Question question = new Question();
					question.setQuestion((String) temp[1]);
					question.setSubject(subject);
					
					Set<Option> options = new HashSet<Option>();
					for (int i = 0; i < temp.length; i=i+2) {
						Option option = new Option();
						option.setOption((String)temp[i]);
						option.setCorrcetOption((Character)temp[i+1]);
						option.setQuestion(question);
						options.add(option);
					}
					question.setOptions(options);
					questionDao.save(question);			
			}
		}
		 
	}
}
