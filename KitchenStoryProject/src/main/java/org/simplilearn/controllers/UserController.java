package org.simplilearn.controllers;

import java.util.List;
import java.util.logging.Logger;

import org.simplilearn.entities.Users;
import org.simplilearn.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@CrossOrigin(origins="*")
public class UserController {
	
	private UserRepository userRepo;
	//Logger log=Logger.getAnonymousLogger();
	
	@Autowired
	public UserController(UserRepository userRepo) {
		this.userRepo=userRepo;
	}

	
	@PostMapping("/register")
	public String registerUser(@RequestBody Users user) {
		
		//log.info("inside registerUser");
		System.out.println("Name: " + user.getUname());
		System.out.println("Phone :"+ user.getUphone());
		System.out.println("Address :"+ user.getUaddress());
		//user.setUserType("Customer");
        userRepo.save(user);
        return ("Hi " + user.getUname() + " you are registered successfully");
		
		
	}
	
	
	@GetMapping("/getAllUsers")
	public List<Users> getAllUsers(){
		
		return userRepo.findAll();
		
		
	}
	
	
	@GetMapping("/findbyaddress/{address}")
		public Users findbyaddress(@PathVariable("address") String address) {
			return userRepo.findByUaddress(address);
			
		
		}
	
	
	@GetMapping("/login/{username}/{pwd}")
	public Users signin(@PathVariable("username") String username, @PathVariable("pwd") String pwd) {
		
				
		Users user=userRepo.findByUnameAndUpasswd(username,pwd);
		
		if(user!=null) {
			
			return user;
		}
		
		else 
			return null;
		
		
	}
	
	
	/*@GetMapping("/checkusername/{uname}")
	public String checkuname(@PathVariable("uname") String uname) {
		//int count=-1;
		Users user=userRepo.findByUname(uname);
		
		if(user!=null) {
			return "Username not available";
		}
		
		else
			return "Username available";
		
	}
	
*/	
	
	@PutMapping("/changepwd/{uname}/{newpassword}")
	public String chgpwd(@PathVariable ("newpassword") String newpwd, @PathVariable ("uname") String uname) {
		 int count=-1;
		count= userRepo.updatePwd(newpwd, uname);
		 //Users user=userRepo.updatePwd(newpwd, uname);
		 System.out.println("Count:"+ count);
		 if(count>0) {
			 return "Password changed";
		 }
		 else 
			 return "Could not change password";
		 
		
	     
	}
	
}
