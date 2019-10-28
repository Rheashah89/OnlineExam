package com.lti.controller;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lti.model.User;
import com.lti.service.RegisterServiceInterface;

@Controller
public class RegisterController {

	@Autowired
	RegisterServiceInterface registerServiceInterface;
	

	@RequestMapping(path="/register.lti",method=RequestMethod.POST)
	public String register(User user, Map model){	
		System.out.println(user.getUserName());
		registerServiceInterface.register(user);
		model.put("message", "Registered Successfully!");
		
		return "login.jsp";
	}
	
	
	
}
