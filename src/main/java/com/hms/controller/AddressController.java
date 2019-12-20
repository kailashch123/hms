package com.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hms.model.Address;
import com.hms.model.User;
import com.hms.service.iface.IAddressService;

@Controller
public class AddressController {
	
	@Autowired
	private IAddressService addressService;
	
	@RequestMapping(value = "/addresslist", method = RequestMethod.GET)
	public String findAll(ModelMap model) {
		List<Address> addrs = addressService.findAll();
		model.addAttribute("addrs", addrs);
		model.addAttribute("loggedinuser", getPrincipal());
		return "addresslist";
	}
	
	@RequestMapping(value = { "/newaddress" }, method = RequestMethod.GET)
	public String newUser(ModelMap model) {
		Address addr = new Address();
		model.addAttribute("address", addr);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipal());
		return "address";
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
	
	@RequestMapping(value = { "/newaddress" }, method = RequestMethod.POST)
	public String save(Address addr, ModelMap model) {
		addressService.save(addr);
		model.addAttribute("Address saved successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "redirect:/addresslist";
	}

	@RequestMapping(value = { "/edit-addr-{addrId}" }, method = RequestMethod.GET)
	public String edit(@PathVariable int addrId, ModelMap model) {
		Address addr = addressService.findById(addrId);
		model.addAttribute("address", addr);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		return "address";
	}

	@RequestMapping(value = { "/edit-addr-{addrId}" }, method = RequestMethod.POST)
	public String updateAddress(Address addr, ModelMap model, @PathVariable int addrId) {
		addressService.update(addr);
		model.addAttribute("Address updated successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "redirect:/addresslist";
	}
}
