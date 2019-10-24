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
		public String search(@RequestParam("firstselect") String firstselect,
				@RequestParam("secondselect1") String secondselect1,
				@RequestParam("secondselect2") String secondselect2,
				@RequestParam("secondselect3") String secondselect3,Map model ){
			String secondselect=null;
			if(firstselect.equals("technology"))
				secondselect=secondselect1;
			else if(firstselect.equals("userState"))
				secondselect=secondselect2;
			else if(firstselect.equals("userCity"))
				secondselect=secondselect3;
			
			List<User> users =adminSearchService.search(firstselect,secondselect);
			
			model.put("users", users);
			
			return "displayRecord.jsp";
			
		}
}
