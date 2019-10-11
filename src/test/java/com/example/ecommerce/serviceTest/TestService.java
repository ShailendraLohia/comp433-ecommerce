package com.example.ecommerce.serviceTest;

import com.example.ecommerce.service.customer.RegisterCustomerImpl;

import org.junit.Before;

public class TestService {

	RegisterCustomerImpl impl;
	
	@Before
	public void setUp() {
		impl = new RegisterCustomerImpl();
	}
	
//	@Test
//	public void testCustomerRegistration() {
//		assertEquals(impl.registerCustomer(), "customer found!");
//	}

}
