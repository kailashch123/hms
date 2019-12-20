package com.hms.service.iface;

import java.util.List;

import com.hms.model.Profile;

public interface IProfileService {

	Profile findById(int id);

	Profile findByType(String type);
	
	List<Profile> findAll();
	
}
