package org.simplilearn.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pid;
	private String name;
	private String category;
	private String description;
	private float price;
	
	//@ManyToMany(mappedBy="products")
	//private Set<PurchaseReport> reports=new HashSet<>();
	
	
	
	public Product() {}

	/*public Product(int pid, String name, String category, String description, int price) {
		super();
		this.pid = pid;
		this.name = name;
		this.category = category;
		this.description = description;
		this.price = price;
	}*/

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
	//helper methods to Reports to a Product
	/*public void addReport(PurchaseReport report) {
		reports.add(report);
	}  */
	
}
