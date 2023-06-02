package org.simplilearn.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.simplilearn.entities.User;
import org.simplilearn.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/login/process")
public class UsersController {
	
	private UserService userService;
	
	@Autowired
	public UsersController(UserService userService) {
		this.userService=userService;
	}
	
	@RequestMapping("/listOfUsers")
	public String showUsers(Model model) {
		
		List<User> users=userService.getAllCustomers();
		
		model.addAttribute("allUsers",users);
		
		return "displayUsers";
		
	}

	
	
	@RequestMapping("/searchUsers")
	public String searchUsers() {
		return "searchUsers";
		
	}
	
	@RequestMapping("/searchWithName")
	public String searchbyName(HttpServletRequest req, Model model) {
		
		String usrnm=req.getParameter("usrnm");
		User user=userService.searchByName(usrnm);
		
		if(user!=null) {
		model.addAttribute("users",user);
		}
		
		else {
			model.addAttribute("msg", "No user with username "+usrnm);
		}
		return "displayUsernm";
		
		
	}
	
	
	@RequestMapping("/searchByPhone")
	public String searchByPhone(HttpServletRequest req,Model model) {
		
		String phone=req.getParameter("phone");
		User user=userService.searchByPhone(phone);
		
		if(user!=null) {
		model.addAttribute("users",user);
		}
		
		else {
			
			model.addAttribute("msg", "No user with phone no. "+ phone);
		}
		
		return "displayUsernm";
		
	}
	
}
