package com.hms.service.iface;

import java.util.List;

import com.hms.model.User;


public interface IUserService {
	
	User findById(int id);
	
	User findByUserName(String userName);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	List<User> findAllUsers(); 
	
	boolean isUserNameUnique(Integer id, String userName);

}