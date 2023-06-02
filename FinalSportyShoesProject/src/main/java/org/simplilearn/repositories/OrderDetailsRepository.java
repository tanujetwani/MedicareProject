package org.simplilearn.repositories;

import java.util.List;

import org.simplilearn.entities.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails,Integer>{
	
	
	@Query(value="select * from order_details o where o.order_id=?1",nativeQuery=true)
	List<OrderDetails>findByOrder_id(int order_id);

}
