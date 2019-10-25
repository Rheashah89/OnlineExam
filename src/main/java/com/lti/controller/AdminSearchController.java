package com.lti.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lti.model.Answer;
import com.lti.model.Exam;
import com.lti.model.Subject;
import com.lti.model.User;
import com.lti.service.AdminSearchService;
import com.lti.service.LoginServiceInterface;

@Controller
@SessionAttributes({"users","exams","answers"})
public class AdminSearchController {
	@Autowired
	private LoginServiceInterface loginServiceInterface;
	@Autowired
	private AdminSearchService adminSearchService;

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

	@RequestMapping(path="/searchbystudentname.lti",method= RequestMethod.POST)
	public String searchUser(@RequestParam("studentEmail") String studentEmail , Map model){
		User user =loginServiceInterface.fetchUserByEmail(studentEmail);
		List<Exam> exams =adminSearchService.searchUsersById(user.getUserID());
		model.put("exams", exams);


		return "studentdetails.jsp";	

	}
	
	@RequestMapping(path="/viewReportBySubjectNameAndEmail.lti",method= RequestMethod.POST)
	public String viewReportBySubjectNameAndEmail(HttpServletRequest request, Map model,
												@RequestParam("examId") int examId){
		
		
		List<Answer> answers =adminSearchService.viewReportBySubjectNameAndEmail(examId);
		model.put("answers", answers);
		
		return null;
	}
	

	
}
