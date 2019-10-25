package com.lti.service;

import com.lti.model.User;

public interface LoginServiceInterface {
	public User fetchUserByEmail(String email);

}
