package org.simplilearn.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class OrderDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ord_detail_id;
	
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="order_id")
	private Order order;
	
	@OneToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="prodid")
	private Product product;
    
	private int quty;
	
	private float amount;
	
	

	public int getOrd_detail_id() {
		return ord_detail_id;
	}

	public void setOrd_detail_id(int ord_detail_id) {
		this.ord_detail_id = ord_detail_id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuty() {
		return quty;
	}

	public void setQuty(int quty) {
		this.quty = quty;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	
}
