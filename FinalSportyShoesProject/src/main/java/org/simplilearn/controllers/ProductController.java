package org.simplilearn.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.simplilearn.entities.Product;
import org.simplilearn.services.ProdService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
	
    private ProdService prodService;
    
    public ProductController(ProdService prodService) {
    	this.prodService=prodService;
    }
    
	@RequestMapping("/addProd")
	public String showAddProd() {
		return "addProd";
	}

	
	@RequestMapping("/addProduct")
	public String addProduct(HttpServletRequest req,Model model) {
		
		String nameProd=req.getParameter("prodName");
		String description=req.getParameter("desc");
		String category=req.getParameter("category");
		float price=Float.parseFloat(req.getParameter("price"));
		
		Product prod=new Product();
		prod.setName(nameProd);
		prod.setDescription(description);
		prod.setCategory(category);
		prod.setPrice(price);
		prodService.addProduct(prod);
		
		model.addAttribute("msg","Product "+ nameProd+ " Added");
		return "product1";
				
	}
	
	@RequestMapping("/deleteProd")
	public String showDeleteProd() {
		return "deleteProd";
	}
	
	@RequestMapping("/deletebyname")
	public String delByName(HttpServletRequest req,Model model) {
		
		
		String prodName=req.getParameter("nameofprod");
		int exception=0, count=0;
		try {
		count=prodService.deleByName(prodName);
		}catch(Exception e) {
			exception=1;
			//e.printStackTrace();
		}
		if(exception==1) {
			model.addAttribute("msg","Product "+ prodName+ " could not be deleted as there is an entry of this product in order_details table");
		}
		else {
			if(count==0) {
				model.addAttribute("msg", "Product with name "+ prodName + " does not exist in the store");
			}
			else {
			
		      model.addAttribute("msg","Product "+ prodName +" deleted");
     		}
		}
		return "product1";
		
	}
	
	@RequestMapping("/deletebyid")
      public String delById(HttpServletRequest req,Model model) {
		
		
		int pid=Integer.parseInt(req.getParameter("pid"));
		int exception=0, count=0;
		try {
		count=prodService.deleteProduct(pid);
		}
		catch(Exception e) {
		     exception=1;	
		}
		
		
		if(exception==1) {
			model.addAttribute("msg","Product with ID "+pid + " cannot be deleted as there is an entry of this product in order_details table");
		}
		else {
			if(count==0) {
				model.addAttribute("msg", "Product with ID "+ pid+ " does not exist in the store");
			}
			else {
		       model.addAttribute("msg","Product with ID "+ pid + " deleted");
		    }
		}
		return "product1";
	}

	
	@RequestMapping("/deletebycategory")
	public String delByCat(HttpServletRequest req,Model model) {
		
		String category=req.getParameter("category");
		int exception=0, count=0;
		try {
		count=prodService.delByCategory(category);
		}catch(Exception e) {
			exception=1;
		}
		
		if(exception==1) {
			model.addAttribute("msg","Products with " + category + " cannot be deleted as there is an entry of such products in the order_details table");
		}
		else{
			if( count==0){
				model.addAttribute("msg", "Products with Category "+ category + " does not exist in the store" );
			}
			else		
		   {
		       model.addAttribute("msg","Products with Category "+ category + " deleted");
		    }
		}	
		return "product1";
	}
	
	
	@RequestMapping("/getAllProd")
	public String getAllProd(Model model) {
		List<Product> products=prodService.getAllProducts();
		model.addAttribute("products1",products);
		return "product";
		
	}
	
	@RequestMapping("/addCategory")
	public String addCat() {
		return "addCategory";
		
		}
	
	
	@RequestMapping("/addProdCategory")
	public String addProCat(HttpServletRequest req,Model model) {
		
		//System.out.println("Inside Prod category");
		int pid=Integer.parseInt(req.getParameter("pid"));
		int exception=0;
		Product prod=null;
		String category=req.getParameter("category");
		try {
		 prod=prodService.getProduct(pid);
		}
		catch(Exception e) {
		exception=1;	
		}
		//System.out.println(prod.getName()+"\t"+ prod.getPid());
	
		if(exception==1) {
			model.addAttribute("msg", "Product with Id " + pid + " does not exist in the store");
		}
		else {
	       
		prod.setCategory(category);
		prod.setDescription("Shoe for "+ category );
		/*prod.setName(prod.getName());
		prod.setDescription(prod.getDescription());
		prod.setPrice(prod.getPrice());
		prod.setPid(prod.getPid());*/
		prodService.updateProduct(pid, prod);
		//prodService.addProduct(prod);
	    model.addAttribute("msg","Added Category "+"'"+ category + "'"+" to Product with ID "+ pid);
		}
		
			 		
		
		
		
	    return "product1";
		
		
	}
	
	
	@RequestMapping("/adminDash")
	public String adminDash() {
		return "adminDashboard";
	}
	
}
