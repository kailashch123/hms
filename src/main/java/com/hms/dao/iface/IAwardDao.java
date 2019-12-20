package com.hms.dao.iface;

import java.util.List;

import com.hms.model.Award;

public interface IAwardDao {

	List<Award> findAll();
	
	Award findById(int awdId);

	void save(Award award);

}
