package com.hms.dao.iface;

import java.util.List;

import com.hms.model.User;


public interface IUserDao {

	User findById(int id);
	
	User findByUserName(String userName);
	
	void save(User user);
	
	List<User> findAllUsers();

}

