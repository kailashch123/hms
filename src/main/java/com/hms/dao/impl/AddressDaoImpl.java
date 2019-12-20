package com.hms.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.hms.dao.iface.IAddressDao;
import com.hms.model.Address;

@Repository("addressDao")
public class AddressDaoImpl extends AbstractDao<Integer, Address> implements IAddressDao {

	static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

	public Address findById(int addrId) {
		Address address = getByKey(addrId);
		return address;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Address> findAll() {
		Criteria criteria = createEntityCriteria();
		List<Address> addresss = (List<Address>) criteria.list();
		return addresss;
	}

	@Override
	public void save(Address addr) {
		persist(addr);
	}

	@Override
	public void delete(int addrId) {
		
	}

	
}
