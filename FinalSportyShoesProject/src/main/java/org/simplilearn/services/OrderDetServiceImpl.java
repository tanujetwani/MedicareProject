package org.simplilearn.services;

import java.util.List;

import org.simplilearn.entities.OrderDetails;
import org.simplilearn.repositories.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetServiceImpl implements OrderDetailsService {

	
	private OrderDetailsRepository orderDetRepo;
	
	@Autowired
	public OrderDetServiceImpl(OrderDetailsRepository orderDetRepo) {
		this.orderDetRepo=orderDetRepo;
	}

	@Override
	public void addOrderDetails(OrderDetails ord_detail) {
		orderDetRepo.save(ord_detail);
		
	}

	@Override
	public List<OrderDetails> getAllorderDetails() {

		return orderDetRepo.findAll();
	}

	@Override
	public OrderDetails getOrderDetails(int order_detail_id) {

		return orderDetRepo.findById(order_detail_id).get();
	}

	@Override
	public List<OrderDetails> getOrdDetByOrdid(int order_id) {
		
		return orderDetRepo.findByOrder_id(order_id);
	}
	
	
	
	
	
}
