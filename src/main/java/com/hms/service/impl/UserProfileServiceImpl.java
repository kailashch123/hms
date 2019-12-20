package com.hms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hms.dao.iface.IProfileDao;
import com.hms.model.Profile;
import com.hms.service.iface.IProfileService;


@Service("profileService")
@Transactional
public class UserProfileServiceImpl implements IProfileService{
	
	@Autowired
	IProfileDao dao;
	
	public Profile findById(int id) {
		return dao.findById(id);
	}

	public Profile findByType(String type){
		return dao.findByType(type);
	}

	public List<Profile> findAll() {
		return dao.findAll();
	}
}
