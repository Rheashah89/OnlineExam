package com.lti.controller;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.lti.service.AnswerService;
import com.lti.service.ExamService;
import com.lti.service.QuestionService;

@Controller
@SessionAttributes({"exam","questions","subject","pointer","selectedId"})
public class ExamController {

	@Autowired
	private ExamService examService;
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private AnswerService answerService;
	
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
		Map<Integer,Question> questions = questionService.fetchQuestions(subject.getSubjectId(),exam.getCurrentLevel());
		
		model.put("questions", questions);
		model.put("pointer", 1);
		Question currentQuestion = questions.get(1);
		model.put("currentQuestion", currentQuestion);
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
	
	@RequestMapping(path="/exam.lti" ,method=RequestMethod.POST)
	public String questionDisplay(HttpServletRequest request, Map model,@RequestParam("cursor") int cursor,
			@RequestParam(value="option",required=false)Integer option){
		Map<Integer,Question> questions = (Map<Integer, Question>) request.getSession().getAttribute("questions");
		
		if(option==null){
			option=0;
		}
		
		Question question =  questions.get((Integer)request.getSession().getAttribute("pointer"));
		Set<Option> options = question.getOptions();
		int score = answerService.checkAnswer(options,option);
		
		Answer answer = new Answer();
		Exam exam = (Exam) request.getSession().getAttribute("exam");
		
		try{
			
			answer=answerService.fetchAnswerByQuestionAndExam(exam.getExamId(),question.getQuestionId());
		}catch (Exception e) {
			answer.setExamId(exam);
			answer.setQuestion(question);
			answer.setScore(score);
			answer.setSelectedId(option);
			answerService.addAnswer(answer);
		}
		
		int key = (int) request.getSession().getAttribute("pointer")+cursor;
		Question currentQuestion = questions.get(key);
		int selectedId;
		try{
		answer=answerService.fetchAnswerByQuestionAndExam(exam.getExamId(),currentQuestion.getQuestionId());
		selectedId = answer.getSelectedId();
		}catch (Exception e) {
			selectedId=0;
		}
		model.put("selectedId", selectedId);
		model.put("currentQuestion", currentQuestion);
		model.put("pointer", key);
		return "exam.jsp";
		
	}
}
