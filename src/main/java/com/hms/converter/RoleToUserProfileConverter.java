package com.hms.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.hms.model.Profile;
import com.hms.service.iface.IProfileService;

@Component
public class RoleToUserProfileConverter implements Converter<Object, Profile>{

	static final Logger logger = LoggerFactory.getLogger(RoleToUserProfileConverter.class);
	
	@Autowired
	IProfileService profileService;

	public Profile convert(Object element) {
		Integer id = Integer.parseInt((String)element);
		Profile profile= profileService.findById(id);
		logger.info("Profile : {}",profile);
		return profile;
	}
	
}