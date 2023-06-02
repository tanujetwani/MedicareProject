package org.simplilearn.repositories;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.simplilearn.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer>{
	
	@Query(value="select * from orders o where o.order_date=?1 and o.user_id=?2",nativeQuery=true)
	Order findByDtnUs(LocalDateTime date , int userid);
	
	@Query(value="select * from orders o where o.order_date like %?1%",nativeQuery=true)
	Set<Order> findByOrder_date(String date);
	
	
	@Query(value="select * from orders o where o.order_id in(select order_id from order_details od where od.prodid in (select pid from product p where p.category=?1))",nativeQuery=true)
	Set<Order> findByCategory(String category);

}
