package com.hms.dao.iface;

import java.util.List;

import com.hms.model.Profile;


public interface IProfileDao {

	List<Profile> findAll();
	
	Profile findByType(String type);
	
	Profile findById(int id);
}
