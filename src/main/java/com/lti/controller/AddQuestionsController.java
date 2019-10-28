package com.lti.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lti.dao.QuestionDao;
import com.lti.dto.AddQuestionFormDto;
import com.lti.dto.AddQuestionsFromFileDto;
import com.lti.model.Option;
import com.lti.model.Question;
import com.lti.model.Subject;
import com.lti.model.User;
import com.lti.service.AddQuestionsService;

@Controller
@SessionAttributes({"user","finalName"})
public class AddQuestionsController {

	@Autowired
	AddQuestionsService addQuestionsService;
	
	

	@RequestMapping(path = "/addQuestionsWithFile.lti", method = RequestMethod.GET)
	public String addQuestionsWithFile(HttpServletRequest request) {
		
		User user = (User)request.getSession().getAttribute("user");
		
		String finalName= (String) request.getSession().getAttribute("finalName");
		if(user==null){
			return "login.jsp";
		}
		
		LinkedHashMap<Integer, ArrayList<ArrayList<String>>> data = addQuestionsService.addQuestionsUsingFile(finalName);
		
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
					addQuestionsService.addQuestion(question);
			}
		}
		return "welcome.jsp";	
	}

	public String AddQuestionWithForm(AddQuestionFormDto addQuestionFormDto,Map model) {
		Subject subject = new Subject();
		
		
		return null;
		
		
	}
	
	
	@RequestMapping(path="/addQuestion.lti", method=RequestMethod.POST)
	public String AddQuestionsFromFile(HttpServletRequest request, AddQuestionsFromFileDto questionsFile,Map model){
		User user = (User)request.getSession().getAttribute("user");
		if(user==null){
			return "login.jsp";
		}
		
		String path = "D:/INPUT/";
		//String filename = questionsFile.getFile().getOriginalFilename();
		String filename = user.getUserName()+"-"+questionsFile.getFile().getOriginalFilename();
		String finalpath = path + filename;
		try {
			questionsFile.getFile().transferTo(new File(finalpath));
			model.put("finalName",filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:addQuestionsWithFile.lti";
		
	}

}
