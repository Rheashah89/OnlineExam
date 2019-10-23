package com.lti.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lti.model.Exam;
import com.lti.model.Question;
import com.lti.model.Subject;
import com.lti.model.User;
import com.lti.service.ExamService;
import com.lti.service.QuestionService;

@Controller
@SessionAttributes({"exam","questions","subject"})
public class ExamController {

	@Autowired
	private ExamService examService;
	
	@Autowired
	private QuestionService questionService;
	
	@RequestMapping(path="/startExam.lti")
	public String loadExamPage(HttpServletRequest request,Map model){
		User user = (User)request.getSession().getAttribute("user");
		Subject subject = (Subject)request.getSession().getAttribute("subject");
		System.out.println(subject.getSubjectId());
		Exam exam = new Exam();
		try{
		exam = examService.fetchExam(user.getUserID(),subject.getSubjectId());
		}catch (Exception e) {
			exam.setSubject(subject);
			exam.setUser(user);
			exam.setCurrentLevel(1);
			exam = examService.save(exam);
			
		}
		model.put("exam", exam);
		List<Question> questions = questionService.fetchQuestions(subject.getSubjectId(),exam.getCurrentLevel());
		for (Question question : questions) {
			System.out.println(question.getQuestion());
		}
		
		model.put("questions", questions);
		return "exam.jsp";
	}
	
	@RequestMapping(path="/selectSubject.lti")
	public String setSubjectInExam(@RequestParam("subjectId") int subId, Map model){
		Subject subject = new Subject();
		subject.setSubjectId(subId);
		System.out.println(subId);
		model.put("subject", subject);
		return "start_exam.jsp";
		
	}
}
