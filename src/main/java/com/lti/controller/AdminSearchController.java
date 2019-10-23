 package com.lti.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lti.model.User;
import com.lti.service.AdminSearchService;

@Controller
@SessionAttributes("users")
public class AdminSearchController {

		@Autowired
		public AdminSearchService adminSearchService;
		
		@RequestMapping(path ="/search.lti", method = RequestMethod.POST)
		public String search(@RequestParam("") String state,Map model ){
			
		
			List<User> users =adminSearchService.search(state);
			
			model.put("users", users);
			
			return "displayRecord.jsp";
			
		}
}
