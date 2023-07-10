package org.simplilearn.controllers;

import java.util.List;

import org.apache.catalina.User;
import org.simplilearn.entities.Cart;
import org.simplilearn.entities.Order;
import org.simplilearn.entities.OrderDetails;
import org.simplilearn.entities.Users;
import org.simplilearn.repositories.CartRepository;
import org.simplilearn.repositories.OrderDetailsRepository;
import org.simplilearn.repositories.OrderRepository;
import org.simplilearn.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
public class OrderController {
	
	private OrderRepository orderRepo;
	private OrderDetailsRepository ordDetRepo;
	private CartRepository cartRepo;
	private UserRepository userRepo;
	
	@Autowired
	public OrderController(OrderRepository orderRepo, OrderDetailsRepository ordDetRepo, CartRepository cartRepo,UserRepository userRepo) {
		
		this.orderRepo=orderRepo;
		this.ordDetRepo=ordDetRepo;
		this.cartRepo=cartRepo;
		this.userRepo=userRepo;
	}
	
	
	@PostMapping("/generateOrder/{userid}")
	
	public  Order createOrder(@PathVariable("userid") int userid) {		
		
		Users user=userRepo.findById(userid).get();
		Order order=new Order();
		order.setUser(user);
		
		orderRepo.save(order);
		
		//OrderDetails ord_detail=new OrderDetails();
		float total_amt=0;
		
		List<Cart> carts=cartRepo.findByUserid(user.getUid());
		
		for (Cart c : carts){
			
			OrderDetails ord_detail=new OrderDetails();
			
			ord_detail.setOrder(order);
			ord_detail.setKitchenitem(c.getKitem());
			ord_detail.setQty(c.getQty());
			ord_detail.setAmount(c.getQty()*(c.getKitem().getPriceperkg()));
			
			
			ordDetRepo.save(ord_detail);
			order.addOrdDetails(ord_detail);
			//ord_detail.setOrder(order);
			//ordDetRepo.save(ord_detail);
			total_amt+=ord_detail.getAmount();
               			
		}
		
		order.setTotal_amt(total_amt);
		orderRepo.save(order);
		
		return order;
		
		
		
		
	}
	

}
