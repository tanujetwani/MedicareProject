package org.simplilearn.services;

import java.util.List;

import org.simplilearn.entities.Cart;
import org.simplilearn.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
	
	private CartRepository cartRepo;
	
	
	@Autowired
	public CartServiceImpl(CartRepository cartRepo) {
		this.cartRepo=cartRepo;
	}

	@Override
	public void addToCart(Cart c) {
		cartRepo.save(c);
		
	}

	@Override
	public void removeFromCart(int prodid,int userid) {
           cartRepo.deleteByUseridAndProdid(prodid,userid);		
	}

	@Override
	public List<Cart> viewCart(int userid) {
		return cartRepo.findByUserid(userid);
		
	}

	@Override
	public Cart getCart(int pid,int userid) {
		
		return cartRepo.findByPidAndUserid(pid,userid);
	}

	@Override
	public void delByUserid(int userid) {
		 cartRepo.deleteByUserid(userid);
		
	}

}
