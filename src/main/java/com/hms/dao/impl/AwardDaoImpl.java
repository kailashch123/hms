package com.hms.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.hms.dao.iface.IAwardDao;
import com.hms.model.Award;

@Repository("awardDao")
public class AwardDaoImpl extends AbstractDao<Integer, Award> implements IAwardDao {

	public Award findById(int awdId) {
		return getByKey(awdId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Award> findAll() {
		Criteria criteria = createEntityCriteria();
		List<Award> awards = (List<Award>) criteria.list();
		return awards;
	}

	@Override
	public void save(Award award) {
		persist(award);
	}

}
