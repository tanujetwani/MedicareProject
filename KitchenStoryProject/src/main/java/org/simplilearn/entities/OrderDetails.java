package org.simplilearn.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
public class OrderDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int order_detail_id;
	
	private float qty;
	
	@ManyToOne
	@JoinColumn(name="order_id")
	//There is a circular reference, Order refer to Order Details and Order Details  refer to Order. It is failing while serializing the Order object to JSon. So adding com.fasterxml.jackson.annotation.JsonIgnore to order field in OrderDetails entity.
	@JsonIgnore
	private Order order;
	
	@OneToOne
	@JoinColumn(name="itemid")
	private KitchenItems kitchenitem;
	
	private float amount;
	
	
	public OrderDetails(){}
	

	
	//Getters and setters
	public int getOrder_detail_id() {
		return order_detail_id;
	}

	public void setOrder_detail_id(int order_detail_id) {
		this.order_detail_id = order_detail_id;
	}

	public float getQty() {
		return qty;
	}

	public void setQty(float qty) {
		this.qty = qty;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public KitchenItems getKitchenitem() {
		return kitchenitem;
	}

	public void setKitchenitem(KitchenItems kitchenitem) {
		this.kitchenitem = kitchenitem;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	

}
