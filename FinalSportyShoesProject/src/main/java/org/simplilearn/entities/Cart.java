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
public class Cart {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cid;
	
	private int qty;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="prodid")
	private Product prod;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="userid")
	private User user;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid =cid;
	}

	public Product getProd() {
		return prod;
	}

	public void setProd(Product prod) {
		this.prod = prod;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
	
	

}
