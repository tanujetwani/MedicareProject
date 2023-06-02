package org.simplilearn.controllers;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.simplilearn.entities.Order;
import org.simplilearn.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import antlr.collections.List;

@Controller
public class ReportsController {
	
	
	private OrderService ordService;
	
	@Autowired
	public ReportsController(OrderService ordService) {
		this.ordService=ordService;
	}
	
	
	@RequestMapping("/reportsByDate")
	public String reportsByDate() {
		return "repDate";
		
	}
	
	
	@RequestMapping("/repByDate")
	
	public String repByDate(HttpServletRequest req,Model model) {
	    
		String date=req.getParameter("dateOfPurchase");
		//DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		//LocalDateTime condate=LocalDateTime.parse(date, formatter);
		//SimpleDateFormat sdf=new SimpleDateFormat("yyyy/M/dd");
		//Date condate=sdf.parse(date);
		Set<Order> ordByDate=ordService.getOrdByDate(date);
		
		
		model.addAttribute("ordersByDate",ordByDate);
		
		
		return "dateReports";	
	}

	
	@RequestMapping("/reportsByCategory")
	public String repCat() {
		
		return "showCat";
	}		
		
	@RequestMapping("/repByCate")
	public String repByCat(HttpServletRequest req,Model model) {
        
		String category=req.getParameter("category1");
		Set<Order> ord1=ordService.getOrdbyCategory(category);
		model.addAttribute("ordbycat",ord1);
		return "catreport";
		
	}
	
}
