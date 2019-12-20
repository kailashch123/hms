package com.hms.service.iface;

import java.util.List;

import com.hms.model.Address;

public interface IAddressService {
	
	Address findById(int addrId);

	List<Address> findAll();

	void save(Address addr);

	void update(Address addr);

	void delete(int addrId);
	
	void delete(Address addr);
}
