package com.hms.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hms.model.Award;
import com.hms.service.iface.IAwardService;

@Controller
public class AwardController {
	
	@Autowired
	private IAwardService awardService;

	@ModelAttribute("years")
	public List<Integer> initYears() {
		List<Integer> years = new ArrayList<Integer>();
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int currYear = cal.get(Calendar.YEAR);
		int startYear = currYear - 50; 
		for(int i = startYear; i <= currYear; i++) {
			years.add(i);
		}
		return years;
	}
	
	@RequestMapping(value = "/awardlist", method = RequestMethod.GET)
	public String findAll(ModelMap model) {
		List<Award> awards = awardService.findAll();
		model.addAttribute("awards", awards);
		model.addAttribute("loggedinuser", getPrincipal());
		return "awardlist";
	}
	
	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
	
	@RequestMapping(value = { "/newaward" }, method = RequestMethod.GET)
	public String newUser(ModelMap model) {
		Award award = new Award();
		model.addAttribute("award", award);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipal());
		return "award";
	}
	
	@RequestMapping(value = { "/newaddress" }, method = RequestMethod.POST)
	public String save(Award award, ModelMap model) {
		awardService.save(award);
		model.addAttribute("Award saved successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "redirect:/awardlist";
	}

	@RequestMapping(value = { "/edit-award-{awdId}" }, method = RequestMethod.GET)
	public String edit(@PathVariable int awdId, ModelMap model) {
		Award award = awardService.findById(awdId);
		model.addAttribute("award", award);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		return "award";
	}

	@RequestMapping(value = { "/edit-award-{awdId}" }, method = RequestMethod.POST)
	public String updateAddress(Award award, ModelMap model, @PathVariable int awdId) {
		awardService.update(award);
		model.addAttribute("Award updated successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "redirect:/awardlist";
	}
	
}
