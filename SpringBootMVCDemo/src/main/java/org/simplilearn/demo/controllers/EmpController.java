package org.simplilearn.demo.controllers;

import java.util.List;

import org.simplilearn.demo.entities.Emp;
import org.simplilearn.demo.services.EmpService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmpController {
	
	private EmpService empService;
	
	public EmpController(EmpService empService) {
		this.empService=empService;
	}

	@RequestMapping("/")
	public String showHome(Model model) {
		
		List<Emp> employees= empService.getEmployees();
		/*for(Emp e :employees) {
			System.out.println(e.getEno()+"\t"+ e.getName()+"\t"+ e.getAddress());
		}*/
		model.addAttribute("emps",employees);
		return "home";
	}
}
