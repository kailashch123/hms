package com.hms.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.hms.dao.iface.IProfileDao;
import com.hms.model.Profile;

@Repository("profileDao")
public class ProfileDaoImpl extends AbstractDao<Integer, Profile> implements IProfileDao {

	public Profile findById(int id) {
		return getByKey(id);
	}

	public Profile findByType(String type) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("type", type));
		return (Profile) crit.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Profile> findAll() {
		Criteria crit = createEntityCriteria();
		crit.addOrder(Order.asc("type"));
		return (List<Profile>) crit.list();
	}

}
