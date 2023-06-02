package org.simplilearn.services;

import java.util.List;

import org.simplilearn.entities.User;

public interface UserService {
	
	public void addUser(User user);
	
	public User validateUser(String username, String password);
	
    public List<User> getAllUsers();
    
    public List<User> getAllCustomers();
    
    public User searchByName(String usrnm);
    
    public User searchByPhone(String phone);

}
