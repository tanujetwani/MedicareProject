package org.simplilearn.services;

import java.util.List;

import org.simplilearn.entities.User;
import org.simplilearn.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepo;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepo) {
		this.userRepo=userRepo;
	}

	@Override
	public void addUser(User user) {
	  userRepo.save(user);
		
	}

	@Override
	public User validateUser(String username, String password) {
         User user=userRepo.findByUsernameAndPassword(username, password);
		return user;
	}

	@Override
	public List<User> getAllUsers() {
          return userRepo.findAll();
	}

	@Override
	public List<User> getAllCustomers() {
		
		return userRepo.findAllCustomers();
	}

	@Override
	public User searchByName(String username) {
		
		return userRepo.findByUsername(username);
	}

	@Override
	public User searchByPhone(String phone) {
		
		return userRepo.findByUserPhone(phone);
	}

}
