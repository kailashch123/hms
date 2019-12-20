package com.hms.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.dao.iface.IAddressDao;
import com.hms.model.Address;
import com.hms.service.iface.IAddressService;

@Service("addressService")
@Transactional
public class AddressServiceImpl implements IAddressService {

	@Autowired
	private IAddressDao addressDao;
	
	@Override
	public Address findById(int addrId) {
		Address addr = addressDao.findById(addrId);
		return addr;
	}

	@Override
	public List<Address> findAll() {
		List<Address> addrs = addressDao.findAll();
		return addrs;
	}

	@Override
	public void save(Address addr) {
		addressDao.save(addr);
	}

	public void update(Address addr) {
		addressDao.update(addr);
	}

	@Override
	public void delete(int addrId) {
		addressDao.delete(addrId);
	}
	
	@Override
	public void delete(Address addr) {
		addressDao.delete(addr);
	}

}
