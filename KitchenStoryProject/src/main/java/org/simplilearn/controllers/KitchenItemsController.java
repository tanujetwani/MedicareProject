package org.simplilearn.controllers;

import java.util.List;

import org.simplilearn.entities.KitchenItems;
import org.simplilearn.repositories.KitchenItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
public class KitchenItemsController {
	
	private KitchenItemRepository itemRepo;
	
	@Autowired
	public KitchenItemsController(KitchenItemRepository itemRepo) {
		this.itemRepo=itemRepo;
	}
	

	@GetMapping("/getitemsByCategory/{category}")
	public List<KitchenItems> getItemsByCategory(@PathVariable String category){
		      
		       
		
		//System.out.println("Pname:"+ pname);
		//System.out.println("Category:"+ category);
		//System.out.println("Brand:"+ brand);
		//System.out.println("Description:"+ description);
		
	             
		        
                return  itemRepo.findByCategory(category);
		        
		        
	}

	
	
	@GetMapping("/getitemsByBrand/{brand}")
	public List<KitchenItems> getitemsByBrand(@PathVariable String brand){
		
		return itemRepo.findByBrand(brand);
	}
	
	
	@GetMapping("/getitemsByCategoryAndBrand/{category}/{brand}")
	public List<KitchenItems> getitemsByCategoryAndBrand(@PathVariable String category, @PathVariable String brand){
		
	      return itemRepo.findByCategoryAndBrand(category, brand);	
	}
	
	
	
	   @PostMapping("/additems")
     	public String addItems(@RequestBody KitchenItems item) {
		   
		   itemRepo.save(item);
		   return ("Item "+ item.getPname()+" added successfully");
		   
		   
	   }
	   
	   
	   @DeleteMapping("/deleteitembyid/{id}")
	   public String deleteItem(@PathVariable("id") int id) {
		   
		  boolean exception=false;
		  int count=-1;
		  try { 
		    count=itemRepo.deleteByPid(id);
		  
		  }
		  catch(Exception e) {
			exception=true;  
			  
		  } 
		//  System.out.println("count: "+ count);
		   if(exception) {
			  
			  return("Item with id "+ id +" could not be deleted as there is an entry of this item in order_details table ");
			  
		  }
		  else {
			  
			  if(count==0) {
				  
				  return("Item with id "+ id + " does not exist in store");
			  }
			  else {
				   return ("Deleted item with id " + id);
			  }
		  }
		  
		 
		  
	   }
	   
	   
        
	   @DeleteMapping("/deleteitembyname/{name}")
         public String delbyname(@PathVariable ("name") String name) {
		   
		   boolean exception=false;
		   int count=-1;   
		   try {
		   count=itemRepo.deleteByPname(name);  //count gives the number of records deleted
		   }
		   
		   catch(Exception e) {
			   exception=true;
		  }
		   
		//   System.out.println("Count:"+ count);
		 if(exception) {
			   
			   return("Item with name "+ name+ " could not be deleted as there is an entry of this item in order_details table.");
		   }
		   else {
			   if(count==0) {
				   return ("Item with name "+ name + " does not exist in store.");
			   }
			   else {
		          return ("Item with name "+ name + " deleted successfully");
		   }
	   }
	   
	   }
	   
	   
	   @DeleteMapping("/deleteitembycategory/{category}")
	   public String delbycategory(@PathVariable("category") String category) {
	        
		   boolean exception=false;
		   int count=-1;
		   try {
		   count=itemRepo.deleteByCategory(category);
		   }
		   catch(Exception e) {
			   exception=true;
		   }
		   
		  // System.out.println("Count:"+ count);
		   
		   if(exception) {
			   return("Item with category "+ category + " cannot be deleted as there is an entry of such items in order_details table");
		   }
		   else {
			   
			   if(count==0) {
				 return ("Item with category "+ category+ " does not exist in store");   
			   }
			   
			   else {
		        return("Item with category "+ category + " deleted");
		   }
		   
	   }

	   }	
	   
	   
	   
	   @GetMapping("/getAllitems")
	   public List<KitchenItems> getAllitems(){
		   
		   return itemRepo.findAll();
	   }

	   
}
