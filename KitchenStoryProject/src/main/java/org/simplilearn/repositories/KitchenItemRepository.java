package org.simplilearn.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.simplilearn.entities.KitchenItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface KitchenItemRepository extends JpaRepository<KitchenItems,Integer> {
	
	@Query(value="select * from Kitchen_items k where k.pname=?1 or k.category=?2 or k.brand=?3 or k.description=?4", nativeQuery=true)
	List<KitchenItems> findByPnameAndCategoryAndBrandAndDescription(String name, String category, String brand, String description);

	
	
	List<KitchenItems> findByCategory(String category);
	
	
	//List<KitchenItems> findByPriceperkg(float price);
	
    @Query(value="select * from kitchen_items k where k.brand=?1", nativeQuery=true)
    List<KitchenItems> findByBrand(String brand);
    
   // @Query(value="select * from kitchen_items k where k.category=?1 and k.brand=?2", nativeQuery=true)
    List<KitchenItems> findByCategoryAndBrand(String category, String brand);
    
    @Transactional
    @Modifying
    @Query(value="delete from kitchen_items k where k.pname=?1", nativeQuery=true)
     int deleteByPname(String name);
    
    
    @Transactional
    @Modifying
    @Query(value="delete from kitchen_items k where k.category=?1", nativeQuery=true)
     int  deleteByCategory(String category);
    
    @Transactional
    @Modifying
    @Query(value="delete from kitchen_items k where k.pid=?1", nativeQuery=true)
    int deleteByPid(int id);

}
