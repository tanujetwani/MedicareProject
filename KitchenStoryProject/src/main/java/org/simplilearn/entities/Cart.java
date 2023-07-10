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
	private int cartid;
	
	private float qty;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="itemid")
	private KitchenItems kitem;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="userid")
	private Users user;
	
	public Cart() {}

	public int getCartid() {
		return cartid;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	public float getQty() {
		return qty;
	}

	public void setQty(float qty) {
		this.qty = qty;
	}

	public KitchenItems getKitem() {
		return kitem;
	}

	public void setKitem(KitchenItems kitem) {
		this.kitem = kitem;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
	    

}
