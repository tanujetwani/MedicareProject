package org.simplilearn.repositories;

import java.util.List;

import org.simplilearn.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	
	User findByUsernameAndPassword(String username, String password);
    
	@Query(value="select * from User u where u.user_type like 'Customer%'", nativeQuery=true)
	List<User> findAllCustomers();
	
	User findByUsername(String username);
	
	User findByUserPhone(String phone);


}
