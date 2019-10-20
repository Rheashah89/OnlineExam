package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.LoginDao;
import com.lti.dao.RegisterDao;
import com.lti.model.User;

@Service
public class LoginService implements LoginServiceInterface {
	@Autowired
	private LoginDao logindao;

	public User login(String email){
		
		return logindao.fetchUser(email);
		
	}
}
