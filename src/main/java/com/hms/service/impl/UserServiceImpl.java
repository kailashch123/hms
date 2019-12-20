package com.hms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hms.dao.iface.IUserDao;
import com.hms.model.User;
import com.hms.service.iface.IUserService;


@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserDao dao;

	@Autowired
    private PasswordEncoder passwordEncoder;
	
	public User findById(int id) {
		return dao.findById(id);
	}

	public User findByUserName(String userName) {
		User user = dao.findByUserName(userName);
		return user;
	}

	public void saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		dao.save(user);
	}

	public void updateUser(User user) {
		User entity = dao.findById(user.getUserId());
		if(entity!=null){
			entity.setUserName(user.getUserName());
			if(!user.getPassword().equals(entity.getPassword())){
				entity.setPassword(passwordEncoder.encode(user.getPassword()));
			}
			entity.setFirstName(user.getFirstName());
			entity.setLastName(user.getLastName());
			entity.setEmail(user.getEmail());
			entity.setUserProfiles(user.getUserProfiles());
		}
	}

	public List<User> findAllUsers() {
		return dao.findAllUsers();
	}

	public boolean isUserNameUnique(Integer userId, String userName) {
		User user = findByUserName(userName);
		return ( user == null || ((userId != null) && (user.getUserId() == userId)));
	}
	
}
