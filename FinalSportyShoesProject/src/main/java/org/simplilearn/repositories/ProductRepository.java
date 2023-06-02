package org.simplilearn.repositories;

import javax.transaction.Transactional;

import org.simplilearn.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{
	
	@Modifying
	@Transactional
	@Query(value="delete from product p where p.name=?1",nativeQuery=true)
	int deleteByName(String name);
	
	
	@Modifying
	@Transactional
	@Query(value="delete from product p where p.category=?1",nativeQuery=true)
	int deleteByCategory(String category);
	
	
	@Modifying
	@Transactional
	@Query(value="delete from product p where p.pid=?1",nativeQuery=true)
	int deleteById(int pid);
	

}
