package com.lti.service;

import java.util.List;

import com.lti.model.User;

public interface RegisterServiceInterface {
	public void register(User user);
	
	public User fetchByEmail(String email);
	

}
