package org.simplilearn.controllers;

import java.util.List;

import org.simplilearn.entities.Cart;
import org.simplilearn.entities.KitchenItems;
import org.simplilearn.entities.Users;
import org.simplilearn.repositories.CartRepository;
import org.simplilearn.repositories.KitchenItemRepository;
import org.simplilearn.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
public class CartController {
	
	UserRepository userRepo;
	KitchenItemRepository itemRepo;
	CartRepository cartRepo;
	
	@Autowired
	public CartController(UserRepository userRepo, KitchenItemRepository itemRepo, CartRepository cartRepo) {
		this.userRepo=userRepo;
		this.itemRepo=itemRepo;
		this.cartRepo=cartRepo;
		
	}
	
	@PostMapping("/addToCart/{itemid}/{userid}")
	public Cart addToCart(@PathVariable("itemid") int itemid, @PathVariable("userid") int userid) {
		
		KitchenItems item =itemRepo.findById(itemid).get();
		Users user= userRepo.findById(userid).get();
		float qty=0;
		
		
		Cart cart1=cartRepo.findByKitemAndUser(itemid,userid);
		
		if(cart1!=null) {
			float qty1=cart1.getQty();
			qty1++;
			cart1.setQty(qty1);
			cartRepo.save(cart1);
			return cart1;
 		}
		else {
			Cart cart=new Cart();
			cart.setKitem(item);
			cart.setUser(user);
			cart.setQty(1);
			cartRepo.save(cart);
		     return cart;	
		}
		
		//return " inserted into Cart ";
		//return cart;
		
		
	}
	
	
	@DeleteMapping("/removefromcart/{itemid}/{userid}")
	public String removeFromCart(@PathVariable("itemid") int itemid, @PathVariable("userid") int userid) {
		  
		cartRepo.deleteByItemidAndUserid(itemid,userid);
		KitchenItems item1=itemRepo.findById(itemid).get();
		return "Removed "+item1.getPname()+ " from Cart";
		
	}
	
	
	@GetMapping("/getitemfromcart/{userid}")
	
	public List<Cart> getItems(@PathVariable("userid") int userid) {
		
	         return cartRepo.findByUserid(userid);	
	}
	

	@DeleteMapping("/delfromcart/{userid}")
	
	public String delfromcart(@PathVariable("userid") int userid) {
	          
		cartRepo.deleteByUserid(userid);
		return "Deleted from cart "+ userid;
		
	}
	
	
}
