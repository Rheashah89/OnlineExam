package com.lti.controller;

import java.io.File;
import java.io.IOException;
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
import com.lti.dto.AddQuestionFormDto;
import com.lti.dto.AddQuestionsFromFileDto;
import com.lti.model.Option;
import com.lti.model.Question;
import com.lti.model.Subject;
import com.lti.service.AddQuestionsService;

@Controller
public class AddQuestionsController {

	@Autowired
	AddQuestionsService addQuestionsService;
	
	@Autowired
	QuestionDao questionDao;

	@RequestMapping(path = "/addQuestionsWithFile.lti", method = RequestMethod.GET)
	public String addQuestionsWithFile() {
		LinkedHashMap<Integer, ArrayList<ArrayList<String>>> data = addQuestionsService.addQuestionsUsingFile();
		
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
					System.out.println(temp.length);
					Set<Option> options = new HashSet<Option>();
					for (int i = 2; i <=temp.length-2; i=i+2) {
						Option option = new Option();
						String str = (String)temp[i];
						if(str.equals("-"))
							continue;
						option.setOption((String)temp[i]);
						option.setCorrcetOption((String)temp[i+1]);
						option.setQuestion(question);
						options.add(option);
					}
					question.setOptions(options);
					question.setQuestionLevel(Integer.parseInt((String) temp[10]));
					questionDao.save(question);
			}
		}
		return "welcome.jsp";	
	}

	public String AddQuestionWithForm(AddQuestionFormDto addQuestionFormDto,Map model) {
		Subject subject1 = new Subject();
		
		
		return null;
		
		
	}
	
	
	
	public String AddQuestionsFromFile(AddQuestionsFromFileDto questionsFile){
		
		String path = "d:/uploads/";
		String filename = questionsFile.getFile().getOriginalFilename();
		String finalpath = path + filename;
		try {
			questionsFile.getFile().transferTo(new File(finalpath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	
	
	
	
	
	
}
