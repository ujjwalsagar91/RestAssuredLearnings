package com.test;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpecTest {
	
	RequestSpecBuilder reqSpec;
	
	@Test
	public RequestSpecification setUri() {
		reqSpec = new RequestSpecBuilder();
		reqSpec.setBaseUri("https://reqres.in");
		reqSpec.setBasePath("/api/users");
		return reqSpec.build();
	}
	
	@Test
	public void getCall() {
		reqSpec.build();
	}

}
