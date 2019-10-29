package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.RegisterDao;
import com.lti.model.User;

@Service
public class RegisterService implements RegisterServiceInterface{

	@Autowired
	private RegisterDao registerDao;
	
	public void register(User user){
		registerDao.save(user);
		//send a mail to notify user after successful registration
	}
	
	public User fetchByEmail(String email){
		return registerDao.fetch(email);
	}
	
	
}
