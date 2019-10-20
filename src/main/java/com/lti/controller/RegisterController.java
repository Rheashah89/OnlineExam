package com.lti.controller;


import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lti.model.User;
import com.lti.service.RegisterService;

@Controller
public class RegisterController {

	@Autowired
	RegisterService registerService;
	

	@RequestMapping(path="/register.lti",method=RequestMethod.POST)
	public String register(User user, Map model){	
		System.out.println(user.getUserName());
		registerService.register(user);
		model.put("message", "Registered Successfully!");
		
		return "confirmation.jsp";
	} 
	
}
