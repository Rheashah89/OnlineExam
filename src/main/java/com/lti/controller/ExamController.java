package com.lti.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lti.model.User;

@Controller
@SessionAttributes("user")
public class ExamController {

@RequestMapping(path="/exam.lti",method=RequestMethod.GET) 
	
	public String showQuestion(Map model){
		User user = (User) model.get("user");
		System.out.println(user.getUserEmail());
		return "welcome.jsp";
	
}
}
