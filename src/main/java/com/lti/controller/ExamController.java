package com.lti.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lti.model.Exam;
import com.lti.model.Question;
import com.lti.model.User;
import com.lti.service.ExamService;
import com.lti.service.QuestionService;

@Controller
@SessionAttributes({"exam","questions"})
public class ExamController {

	@Autowired
	private ExamService examService;
	
	@Autowired
	private QuestionService questionService;
	
	@RequestMapping(path="/startExam.lti")
	public String loadExamPage(Map model){
		User user = (User)model.get("user");
		Exam exam = examService.fetchExam(user.getUserID());
		List<Question> questions = questionService.fetchQuestions(exam.getSubject().getSubjectId());
		for (Question question : questions) {
			System.out.println(question.getQuestion());
		}
		model.put("exam", exam);
		model.put("questions", questions);
		return "exam.jsp";
	}
}
