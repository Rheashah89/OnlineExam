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
import com.lti.model.Report;
import com.lti.model.Subject;
import com.lti.model.User;
import com.lti.service.AnswerService;
import com.lti.service.ExamService;
import com.lti.service.QuestionService;
import com.lti.service.ReportService;

@Controller
@SessionAttributes({"user","exam","questions","subject","pointer","selectedId","report"})
public class ExamController {

	@Autowired
	private ExamService examService;
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private AnswerService answerService;
	
	@Autowired
	private ReportService reportService;
	
	@RequestMapping(path="/selectSubject.lti")
	public String setSubjectInExam(HttpServletRequest request,@RequestParam("subjectId") int subId, Map model){
		
		User user = (User)request.getSession().getAttribute("user");
		if(user==null){
			return "login.jsp";
		}
		
		Subject subject = new Subject();
		subject.setSubjectId(subId);
		System.out.println(subId);
		model.put("subject", subject);
		return "start_exam.jsp";
		
	}
	
	@RequestMapping(path="/startExam.lti")
	public String loadExamPage(HttpServletRequest request,Map model){
		User user = (User)request.getSession().getAttribute("user");
		if(user==null){
			return "login.jsp";
		}
		Subject subject = (Subject)request.getSession().getAttribute("subject");
		System.out.println(subject.getSubjectId());
		
		Exam exam = examService.fetchExam(user,subject);
		exam.setNoOfAttempts(exam.getNoOfAttempts()+1);
		exam = examService.fetchExam(user,subject);
		exam.getSubject().getSubjectId();
		model.put("exam", exam);
		Map<Integer,Question> questions = questionService.fetchQuestions(subject.getSubjectId(),exam.getCurrentLevel());
		
		System.out.println(questions.get(1));
		
		model.put("questions", questions);
		model.put("pointer", 0);
		Question currentQuestion = questions.get(0);
		model.put("currentQuestion", currentQuestion);
		return "exam.jsp";
	}
	
	
	
	@RequestMapping(path="/exam.lti" ,method=RequestMethod.POST)
	public String questionDisplay(HttpServletRequest request, Map model,@RequestParam(value="cursor",required=false) Integer cursor,
			@RequestParam(value="option",required=false)Integer option,
			@RequestParam(value="submitExam",required=false)Integer submitExam){
		
		User user = (User)request.getSession().getAttribute("user");
		if(user==null){
			return "login.jsp";
		}
		
		Map<Integer,Question> questions = (Map<Integer, Question>) request.getSession().getAttribute("questions");
		
		if(option==null){
			option=0;
		}
		
		if(submitExam==null){
			submitExam=0;
		}
		
		if(cursor==null){
			cursor=0;
		}
		
		Question question =  questions.get((Integer)request.getSession().getAttribute("pointer"));
		Set<Option> options = question.getOptions();
		int score = answerService.checkAnswer(options,option);

		Exam exam = (Exam) request.getSession().getAttribute("exam");
		
		Answer answer = answerService.getAnswer(exam,question,score,option);
		
		int key = (int) request.getSession().getAttribute("pointer")+cursor;
		Question currentQuestion = questions.get(key);
		int selectedId;
		try{
		answer=answerService.fetchAnswerByQuestionAndExam(exam.getExamId(),currentQuestion.getQuestionId());
		selectedId = answer.getSelectedId();
		}catch (Exception e) {
			selectedId=0;
		}
		
		Report report = reportService.getReport(exam,score);
		model.put("report", report);
		
		if(submitExam==1){
			if(report.getTotalMarks()==12){
				report.setClearedLevel(exam.getCurrentLevel());
			}
			model.put("report", report);
			return "report.jsp";
		}
		
		model.put("selectedId", selectedId);
		model.put("currentQuestion", currentQuestion);
		model.put("pointer", key);
		return "exam.jsp";
	}
	
}
