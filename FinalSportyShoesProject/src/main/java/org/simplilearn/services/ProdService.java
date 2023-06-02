package org.simplilearn.services;

import java.util.List;

import org.simplilearn.entities.Product;

public interface ProdService {
	
	public void addProduct(Product p);
	
	public void updateProduct(int pid,Product p);
	
	public int deleteProduct(int pid);
	
	public List<Product> getAllProducts();
	
	public Product getProduct(int pid);
	
	public int deleByName(String name);
	
	public int delByCategory(String category);

}
