package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.ReportDao;
import com.lti.model.Exam;
import com.lti.model.Report;

@Service
public class ReportService {

	@Autowired
	ReportDao reportDao;
	
	public Report getReport(Exam exam,int score){
		
		Report report = null;
		try{
		report= (Report)reportDao.fetchByExamId(exam.getExamId());
		}catch (Exception e) {
			report = new Report();
			report.setExam(exam);
			report.setTotalMarks(0);
			report = (Report) reportDao.save(report);
		}
		
		report.setTotalMarks(report.getTotalMarks()+score);
		report = (Report) reportDao.save(report);
		return report;
	}
}
