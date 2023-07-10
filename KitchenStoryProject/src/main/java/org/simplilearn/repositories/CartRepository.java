package org.simplilearn.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.simplilearn.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {
	
	@Query(value="select * from cart c where c.itemid=?1 and c.userid=?2", nativeQuery=true)
	public Cart findByKitemAndUser(int itemid,int userid);
	
	@Transactional
	@Modifying
	@Query(value="delete from  cart c where c.itemid=?1 and c.userid=?2", nativeQuery=true)
	 void deleteByItemidAndUserid(int itemid, int userid);
	
	
	@Query(value="select * from Cart c where c.userid=?1", nativeQuery=true)
	public List<Cart> findByUserid(int userid);
	
	@Transactional
	@Modifying
	@Query(value="delete from Cart c where c.userid=?1", nativeQuery=true)
	public void deleteByUserid(int userid);
	
	

}
