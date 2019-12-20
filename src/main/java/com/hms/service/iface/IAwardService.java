package com.hms.service.iface;

import java.util.List;

import com.hms.model.Award;

public interface IAwardService {

	List<Award> findAll();

	Award findById(int awdId);
	
	void save(Award award);
	
	void update(Award award);
	
}
