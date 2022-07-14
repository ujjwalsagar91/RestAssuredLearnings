package com.test;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class EmployeePOJOWithLombok {

	private String name;
	private String id;
	private String createdAt;
	private AddressPOJO address;
	
}
