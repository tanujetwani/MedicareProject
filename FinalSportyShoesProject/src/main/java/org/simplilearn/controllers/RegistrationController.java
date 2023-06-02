package org.simplilearn.controllers;

import javax.servlet.http.HttpServletRequest;

import org.simplilearn.entities.User;
import org.simplilearn.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/register")
public class RegistrationController {

	
	private UserService userService;
	
	@Autowired
	public RegistrationController(UserService userService) {
		this.userService=userService;
	}
	
	
	@RequestMapping("/show")
	public String showRegistrationForm() {
		return "register";
	}
	
	
	@RequestMapping(value="/process", method=RequestMethod.POST)
	public String registerUser(HttpServletRequest req) {
		
		String usernm=req.getParameter("username");
		String pwd=req.getParameter("pwd");
		String phone=req.getParameter("phone");
		User user=new User();
		user.setUsername(usernm);
		user.setPassword(pwd);
		user.setUserPhone(phone);
		user.setUserType("Customer");
		user.setActive("active");
	    userService.addUser(user);	
	    return "home";
		
	}
	
}
