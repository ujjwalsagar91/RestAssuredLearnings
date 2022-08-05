package com.test;

import org.testng.annotations.Test;

import com.test.EmployeePOJOWithLombok.EmployeePOJOWithLombokBuilder;

public class TestBuilderLombok {
	
	@Test
	public void testBuilder() {
		
		
		EmployeePOJOWithLombok emp = EmployeePOJOWithLombok.builder().setId("2").build();
	}

}
