package com.test;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(value="createdAt")
public class EmployeePOJO {
	
	@JsonProperty("first name")
	private String name;
	private String id;
	private String createdAt;
	
	private AddressPOJO address;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public AddressPOJO getAddress() {
		return address;
	}
	public void setAddress(AddressPOJO address) {
		this.address = address;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
}
