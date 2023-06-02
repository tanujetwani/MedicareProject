package org.simplilearn.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	private String userType;
	private String userPhone;
	private String active;
	
	@OneToMany(mappedBy="user")
	private Set<Cart> carts=new HashSet<>();
	
	//@OneToMany(mappedBy="user")
	//private Set<PurchaseReport> reports=new HashSet<>();
	
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	private Set<Order> orders=new HashSet<>();
	
	
	
	public Set<Cart> getCarts() {
		return carts;
	}
	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}

	
	
	
  /*  public Set<PurchaseReport> getReports() {
		return reports;
	}
	public void setReports(Set<PurchaseReport> reports) {
		this.reports = reports;
	} */
	
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
		
	}
	
	
	//helper methods to add cart to a user
	public void addCart(Cart cart) {
    	carts.add(cart);
    	
	}
    	
    	//helper methods to add reports to a user
   /* public void addReport(PurchaseReport report) {
    	reports.add(report);
    
 
    }  */
	
	
	//helper methods to add order
	public void addOrder(Order order) {
		orders.add(order);
	}
    
    
}
