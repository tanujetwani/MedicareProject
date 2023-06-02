package org.simplilearn.services;

import java.util.List;

import org.simplilearn.entities.Product;
import org.simplilearn.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdServiceImpl implements ProdService{
	
	private ProductRepository prodRepo;
	
	@Autowired
	public ProdServiceImpl(ProductRepository prodRepo) {
		this.prodRepo=prodRepo;
	}

	@Override
	public void addProduct(Product p) {
           prodRepo.save(p);		
		
	}

	@Override
	public void updateProduct(int pid, Product p) {
          
		Product prod1=prodRepo.findById(pid).get();
		prod1.setName(p.getName());
		prod1.setCategory(p.getCategory());
		prod1.setPrice(p.getPrice());
		prod1.setDescription(p.getDescription());
		prodRepo.save(prod1);
		
	}

	@Override
	public int deleteProduct(int pid) {
		
		
		 return prodRepo.deleteById(pid);
		
		
		
	}

	@Override
	public List<Product> getAllProducts() {
		
		return prodRepo.findAll();
	}

	@Override
	public Product getProduct(int pid) {

		return prodRepo.findById(pid).get();
	}

	@Override
	public int deleByName(String name) {
	     return prodRepo.deleteByName(name);
		
	}

	@Override
	public int delByCategory(String category) {
		return prodRepo.deleteByCategory(category);
		
	}

}
