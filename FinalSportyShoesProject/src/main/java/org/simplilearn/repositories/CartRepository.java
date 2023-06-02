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
	
	@Transactional
	@Modifying
	@Query(value="delete from cart c where c.prodid=?1 and c.userid=?2",nativeQuery=true)
	void deleteByUseridAndProdid(int prodid, int userid);
	
	
	@Query(value="select * from cart c where c.userid=?1",nativeQuery=true)
	List<Cart> findByUserid(int userid);
    
	
	@Query(value="select * from cart c where c.prodid=?1 and c.userid=?2",nativeQuery=true)
	Cart findByPidAndUserid(int pid,int userid);
	
	@Transactional
	@Modifying
	@Query(value="delete from cart c where c.userid=?1",nativeQuery=true)
	void deleteByUserid(int userid);
	
}
