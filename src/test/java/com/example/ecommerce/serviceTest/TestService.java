package com.example.ecommerce.serviceTest;

import com.example.ecommerce.service.workflow.customer.CustomerActivity;

import org.junit.Before;

public class TestService {

	CustomerActivity impl;
	
	@Before
	public void setUp() {
		impl = new CustomerActivity();
	}
	
//	@Test
//	public void testCustomerRegistration() {
//		assertEquals(impl.registerCustomer(), "customer found!");
//	}

}
