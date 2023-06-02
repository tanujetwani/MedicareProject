package org.simplilearn.services;

import java.util.List;

import org.simplilearn.entities.Cart;

public interface CartService {

	
	public void addToCart(Cart c);
	public void removeFromCart(int prodid,int userid);
	
	public List<Cart> viewCart(int userid);
	
	public Cart getCart(int pid,int userid);
	
	public void delByUserid(int userid);
	
}
