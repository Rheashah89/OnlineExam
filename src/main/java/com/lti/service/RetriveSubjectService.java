package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.RetriveSubjectDao;
import com.lti.model.Subject;

@Service
public class RetriveSubjectService {

	@Autowired
	public RetriveSubjectDao retriveSubjectDao;
	
	public List<Subject> fetchAll(){
		
		return retriveSubjectDao.fetchAll();
	}
	
}
