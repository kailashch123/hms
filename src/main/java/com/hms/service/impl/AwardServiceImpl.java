package com.hms.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.dao.iface.IAwardDao;
import com.hms.model.Award;
import com.hms.service.iface.IAwardService;

@Service("awardService")
@Transactional
public class AwardServiceImpl implements IAwardService {
	
	@Autowired
	private IAwardDao awardDao;

	@Override
	public List<Award> findAll() {
		return awardDao.findAll();
	}

	@Override
	public void save(Award award) {
		awardDao.save(award);
	}

	@Override
	public void update(Award award) {
		Award entity = awardDao.findById(award.getAwdId());
		if(entity!=null){
			entity.setName(award.getName());
			entity.setYear(award.getYear());
		}
	}

	@Override
	public Award findById(int awdId) {
		return awardDao.findById(awdId);
	}

}
