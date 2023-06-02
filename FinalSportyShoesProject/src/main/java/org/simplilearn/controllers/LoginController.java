package org.simplilearn.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.simplilearn.entities.Product;
import org.simplilearn.entities.User;
import org.simplilearn.services.ProdService;
import org.simplilearn.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	private UserService userService;
	
	private ProdService prodService;
	@Autowired
	public LoginController(UserService userService, ProdService prodService) {
		
		this.userService=userService;
		this.prodService=prodService;
		
	}
	
	@RequestMapping("/show")
	public String showLoginform() {
		return "login";
		
	}
	
	@RequestMapping(value="/process" , method=RequestMethod.POST)
	public String signinUser(HttpServletRequest req, HttpSession session , Model model) {
		
		String viewName="";
		String usrnm=req.getParameter("usrnm");
		String pwd=req.getParameter("passwd");
		
		User user=userService.validateUser(usrnm, pwd);
		//System.out.println(user.getUsername()+"\t"+ user.getUserType()+"\t"+ user.getPassword());
		
		if(user!=null) {
			
			session.setAttribute("cuser", user);
			
			if(user.getUserType().equalsIgnoreCase("Customer")) {
				//System.out.println(user.getUsername()+"\t"+ user.getUserType()+"\t"+ user.getPassword());
	        List<Product> products= prodService.getAllProducts();
	        model.addAttribute("products1",products);
			viewName= "customerDashboard";
			
			}
			
		     if (user.getUserType().equalsIgnoreCase("Admin")) {
		    	 
				viewName="adminDashboard";
			}
			
		}
		else {
			model.addAttribute("msg", "Incorrect username or password");
              viewName="login";		
		}
		
        return viewName;
		
	}

	}
