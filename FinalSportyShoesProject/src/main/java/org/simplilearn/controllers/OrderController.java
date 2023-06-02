package org.simplilearn.controllers;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.simplilearn.entities.Cart;
import org.simplilearn.entities.Order;
import org.simplilearn.entities.OrderDetails;
import org.simplilearn.entities.Product;
import org.simplilearn.entities.User;
import org.simplilearn.services.CartService;
import org.simplilearn.services.OrderDetailsService;
import org.simplilearn.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {
	
	private OrderService ordService;
	private OrderDetailsService ord_det_Service;
	private CartService cartService;
	
	@Autowired
	public OrderController(OrderService ordService,OrderDetailsService ord_det_Service,CartService cartService ) {
		this.ordService=ordService;
		this.ord_det_Service=ord_det_Service;
		this.cartService=cartService;
	}

	
	@RequestMapping("/buyProd")
	public String buyProd(HttpSession session,Model model) {
        
		User user=(User)session.getAttribute("cuser");
		Order ord1=new Order();
		ord1.setUser(user);
		
		//OrderDetails ord_det1=new OrderDetails();
		//OrderDetails ord_det1=new OrderDetails();
		float total_amt=0;
		
		ordService.addOrder(ord1);
		List<Cart> carts= cartService.viewCart(user.getId());
		
		for(Cart c: carts) {
			
			Product prod=c.getProd();
			OrderDetails ord_det1=new OrderDetails();
			ord_det1.setProduct(prod);
			ord_det1.setQuty(c.getQty());
			ord_det1.setAmount(c.getQty()*prod.getPrice());
			
			ord1.addOrdDetails(ord_det1);
			ord_det1.setOrder(ord1);
			//ordService.addOrder(ord1);
			ord_det_Service.addOrderDetails(ord_det1);
			total_amt+=ord_det1.getAmount();
		}
		
		//ord_det1.setOrder(ord1);
		ord1.setTotal_amount(total_amt);
		
		ordService.addOrder(ord1);
		//ord_det_Service.addOrderDetails(ord_det1);
		LocalDateTime date=ord1.getOrder_date();
		Order ord=ordService.getOrderByDtnUs(date,user.getId());
		model.addAttribute("order",ord);
		
		List<OrderDetails> ord_dets=ord_det_Service.getOrdDetByOrdid(ord.getOrder_id());
		model.addAttribute("ord_dets1",ord_dets);
		
		 return "purchase_report"; 
		
		
	}
	
	
	@RequestMapping("/paytheamount")
	public String payamt(HttpSession session,Model model) {
		
		User user=(User)session.getAttribute("cuser");
		cartService.delByUserid(user.getId());
		model.addAttribute("msg","Thanks for Shopping," + user.getUsername()+" .Ur order is confirmed and will be delivered.");
        
		
		return "thankyou";	
		
		
	}
	
}
