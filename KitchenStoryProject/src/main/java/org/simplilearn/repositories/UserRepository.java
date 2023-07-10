package org.simplilearn.repositories;

import javax.transaction.Transactional;

import org.simplilearn.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {
	
	Users findByUaddress(String address);
	
	@Query(value="select * from Users u where u.uname=?1 and u.upasswd=?2", nativeQuery=true)
	Users findByUnameAndUpasswd(String uname, String upasswd);
	
	@Transactional
	@Modifying
	@Query(value="update users u set u.upasswd=?1 where u.uname=?2", nativeQuery=true)
	int updatePwd(String newpwd, String uname);
	
	@Query(value="select * from Users u where u.uname=?1", nativeQuery=true)
	Users findByUname(String uname);

}
