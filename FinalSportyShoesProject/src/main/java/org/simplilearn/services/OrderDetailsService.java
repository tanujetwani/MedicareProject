package org.simplilearn.services;

import java.util.List;

import org.simplilearn.entities.OrderDetails;

public interface OrderDetailsService {
	
	public void addOrderDetails(OrderDetails ord_detail);
	
	public List<OrderDetails> getAllorderDetails();
	
	public OrderDetails getOrderDetails(int order_detail_id);
	
	public List<OrderDetails> getOrdDetByOrdid(int order_id);

}
