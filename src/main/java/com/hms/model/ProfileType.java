package com.hms.model;

public enum ProfileType {
	
	USER("USER"), DBA("DBA"), ADMIN("ADMIN");

	String type;

	private ProfileType(String type){
		this.type = type;
	}

	public String getProfileType() {
		return type;
	}

}
