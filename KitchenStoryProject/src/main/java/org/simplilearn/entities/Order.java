package org.simplilearn.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;

@Entity(name="Orders")
@AllArgsConstructor
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int order_id;
	
	@CreationTimestamp
	private LocalDateTime order_date;
	
	private float total_amt;
	
	@ManyToOne
	@JoinColumn(name="userid")
	private Users user;
	
	@OneToMany(mappedBy="order")
    private Set<OrderDetails> ord_details= new HashSet<>();
	
	
	//Default constructor
	public Order() {}
	
	
	//Getters and Setters

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public LocalDateTime getOrder_date() {
		return order_date;
	}

	public void setOrder_date(LocalDateTime order_date) {
		this.order_date = order_date;
	}

	public float getTotal_amt() {
		return total_amt;
	}

	public void setTotal_amt(float total_amt) {
		this.total_amt = total_amt;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Set<OrderDetails> getOrd_details() {
		return ord_details;
	}

	public void setOrd_details(Set<OrderDetails> ord_details) {
		this.ord_details = ord_details;
	}
	
	
         //helper methods to add order details in Order
	
	public void addOrdDetails(OrderDetails ord_detail) {
		ord_details.add(ord_detail);
	}
	
	
}
