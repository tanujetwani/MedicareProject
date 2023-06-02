package org.simplilearn.controllers;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.simplilearn.entities.Cart;
import org.simplilearn.entities.Product;
import org.simplilearn.entities.User;
import org.simplilearn.services.CartService;
import org.simplilearn.services.ProdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartController {
	
	private ProdService prodService;
	private CartService cartService;
	Logger log=Logger.getAnonymousLogger();
	
	@Autowired
	public CartController(ProdService prodService,CartService cartService) {
		
		this.prodService=prodService;
		this.cartService=cartService;
	}
	
	@RequestMapping("/addToCart")
	public String addCart(HttpServletRequest req,HttpSession session, Model model) {
		
		//ModelAndView mv=new ModelAndView();
		log.info("inside Add to Cart");
		int pid=Integer.parseInt(req.getParameter("pid"));
		User user=(User)session.getAttribute("cuser");
		Cart c=cartService.getCart(pid,user.getId());
		
		if(c!=null) {
			int qty1=c.getQty();
			qty1++;
			c.setQty(qty1);
			cartService.addToCart(c);
		}
		
		else {
			
        Product prod=prodService.getProduct(pid);
        //User user=(User)session.getAttribute("cuser");
        System.out.println(user.getUsername()+"\t"+user.getId());
        Cart cart=new Cart();
        cart.setProd(prod);
        cart.setUser(user);
        cart.setQty(1);
        cartService.addToCart(cart);
		}
		
        List<Product> products=prodService.getAllProducts();
        model.addAttribute("products1",products);
        //mv.addObject("products1",);
        //mv.setViewName("customerDashboard");
       // return "bravo";
        //model.addAttribute("msg","Added to Cart");
        return "customerDashboard";
       // return mv;
        
       	}
	
	
	@RequestMapping("/removeFromCart")
    public String removeCart(HttpServletRequest req, HttpSession session,Model model) {
         
		int pid=Integer.parseInt(req.getParameter("pid"));
		Product prod1=prodService.getProduct(pid);
		User user1=(User)session.getAttribute("cuser");
		cartService.removeFromCart(pid,user1.getId());
		List<Product> products=prodService.getAllProducts();
		model.addAttribute("products1",products);
	    return "customerDashboard";	
		
		
	}
	
	
	@RequestMapping("/viewCart")
	public String viewCart(HttpSession session,Model model) {
		
		log.info("inside View To Cart");
		User user1=(User)session.getAttribute("cuser");
		List<Cart> cart1=cartService.viewCart(user1.getId());
		model.addAttribute("cart1", cart1);
		return "cart";
	}
}
