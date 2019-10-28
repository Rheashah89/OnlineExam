package com.lti.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lti.model.User;
import com.lti.service.LoginService;
import com.lti.service.LoginServiceInterface;


@Controller
@SessionAttributes("user")
public class LoginController {
	@Autowired
	LoginServiceInterface loginServiceInterface;

	@RequestMapping(path="/login.lti",method=RequestMethod.POST) 
	public String login(HttpServletRequest request,@RequestParam("email") String email, @RequestParam("password") String password  , Map model){

		User user = (User)request.getSession().getAttribute("user");
		if(user==null){
			user = loginServiceInterface.fetchUserByEmail(email);
			String admin="A";

			model.put("user", user);
			if(email.equals(user.getUserEmail()) && password.equals(user.getUserPassword())){
				if(admin.equals(user.getUserRole())){
					return "admin.html";
				}
				else {
					return "welcome.jsp";
				}

			}
			return "login.jsp";	
		}
		else
		{
			return "welcome.jsp";
		}

	}


	@RequestMapping(path="/enterEmail.lti",method=RequestMethod.GET)
	public String forgotPassword(@RequestParam("email") String email, Map model){
		User user = loginServiceInterface.fetchUserByEmail(email);
		model.put("user", user);
		return "securityQuestion.jsp";	
	}

	@RequestMapping(path="/validateUser.lti",method=RequestMethod.POST)
	public String checkUser(@RequestParam("answer") String answer, Map model,HttpServletRequest request){
		User user = (User)request.getSession().getAttribute("user");
		if(user.getSecurityAnswer().equalsIgnoreCase(answer)){
			model.put("message", "Change Password");
			return "forget_password.jsp";
		}
		model.put("message","Sorry! you are not a valid user...Please Try Again!");
		return "login.jsp";	
	}

	@RequestMapping(path="/forgetPassword.lti",method=RequestMethod.POST)
	public String changePassword(@RequestParam("newpassword") String password,HttpServletRequest request,Map model){
		User user = (User)request.getSession().getAttribute("user");
		user.setUserPassword(password);
		user = loginServiceInterface.updateUser(user);
		model.put("message", "Password Changed Successfully! Please login with new password");
		return "login.jsp";
	}

	@RequestMapping(path="/logout.lti")
	public String logout(HttpServletRequest request, Map model){
		model.clear();
		request.getSession().invalidate();
		return "index.html";
	}
}
