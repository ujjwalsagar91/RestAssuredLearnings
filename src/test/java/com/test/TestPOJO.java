package com.test;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class TestPOJO {
	
	@Test
	public void testPojo() {
		
		AddressPOJO add = new AddressPOJO();
		add.setStateName("Maharashtra");
		add.setCityName("Pune");
		add.setPincode(411027);

		EmployeePOJO emp = new EmployeePOJO();
		emp.setAddress(add);
		emp.setName("Ujjwal");
		
		Response res = given().contentType(ContentType.JSON).body(emp).log().all().post("https://reqres.in/api/users");
		
		res.prettyPrint();
		
		EmployeePOJO emp1 = res.as(EmployeePOJO.class);
		System.out.println(emp1.getId());
		System.out.println(emp1.getName());
		
		EmployeePOJOWithLombok emp2 = res.as(EmployeePOJOWithLombok.class);
		System.out.println(emp2);
		System.out.println(emp1.getName());
		
	}
}