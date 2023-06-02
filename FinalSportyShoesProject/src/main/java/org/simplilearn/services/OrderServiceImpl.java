package org.simplilearn.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.simplilearn.entities.Order;
import org.simplilearn.entities.User;
import org.simplilearn.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{
	
	private OrderRepository orderRepo;
	
	@Autowired
	public OrderServiceImpl(OrderRepository orderRepo) {
		this.orderRepo=orderRepo;
	}

	@Override
	public void addOrder(Order order) {
		orderRepo.save(order);
		
	}

	@Override
	public List<Order> getAllOrders() {

		return orderRepo.findAll();
	}

	@Override
	public Order getOrder(int order_id) {

		return orderRepo.findById(order_id).get();
	}

	@Override
	public Order getOrderByDtnUs(LocalDateTime date, int id) {
		return orderRepo.findByDtnUs(date,id);
	}

	@Override
	public Set<Order> getOrdByDate(String date) {
		
		return orderRepo.findByOrder_date(date);
	}

	@Override
	public Set<Order> getOrdbyCategory(String category) {
		
		return orderRepo.findByCategory(category);
	}
	
	

}
