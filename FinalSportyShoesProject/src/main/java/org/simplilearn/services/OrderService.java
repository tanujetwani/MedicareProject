package org.simplilearn.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.simplilearn.entities.Order;
import org.simplilearn.entities.User;

public interface OrderService {
	
	public void addOrder(Order order);
	
	public List<Order>getAllOrders();
	
	public Order getOrder(int order_id);
	
	//public Order getOrderByDtnUs(LocalDateTime date,int userid);

	public Order getOrderByDtnUs(LocalDateTime date, int id);
	
	public Set<Order> getOrdByDate(String date);
	
	public Set<Order> getOrdbyCategory(String category);

}
