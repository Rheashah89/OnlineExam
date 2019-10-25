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
import com.lti.model.Option;
import com.lti.model.Question;
import com.lti.model.Subject;
import com.lti.model.User;
import com.lti.service.AdminSearchService;
import com.lti.service.LoginServiceInterface;

@Controller
@SessionAttributes({"users","exams","options"})
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
		System.out.println(examId);
		
		
		List<Question> questions =adminSearchService.viewReportBySubjectNameAndEmail(examId);
		
//		for(Question q: questions){
//		System.out.println(q.getQuestion());
//		System.out.println(q.getOptions());
//		
//		}
		model.put("questions", questions);
		
		return "studentExamInfo.jsp";
	}
	
	
	
	@RequestMapping(path="/removequestion.lti" , method= RequestMethod.POST)
	public String removeQuestion(@RequestParam("subjectId") int subjectId, @RequestParam("level") int level, Map model){
		
		List<Question> questions = adminSearchService.removeQuestion(subjectId,level);
		model.put("questions", questions);
		
		return "ques_remove.jsp";
		
	}
	
	@RequestMapping(path="/deleteQuestion.lti" , method= RequestMethod.POST)
	public String removeQuestionById(@RequestParam("questionId") int questionId,Map model){
		
		adminSearchService.removeQuestionById(questionId);
		
		return "ques_remove.jsp";
	}

	
}
