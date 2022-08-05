package com.test;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(setterPrefix = "set")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeePOJOWithLombok {

	@JsonPropertyOrder({""})
	
	@JsonProperty("first_name")
	private String name;
	@JsonProperty("id")
	private String id;
	@JsonProperty("created_At")
	private String createdAt;
	@JsonProperty("address")
	private AddressPOJO address;
	
}
