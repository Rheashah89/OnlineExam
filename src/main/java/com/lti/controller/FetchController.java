package com.lti.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lti.service.LoginService;

@Controller
public class FetchController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping(path="/userDeatils.lti", method=RequestMethod.GET)
	public String fetchUser(){
		return "profile.jsp";
		
	}
}
