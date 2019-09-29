package com.example.ecommerce.serviceTest;

import static org.junit.Assert.*;
import com.example.ecommerce.service.RegisterCustomerImpl;

import org.junit.Before;
import org.junit.Test;

public class TestService {

	RegisterCustomerImpl impl;
	
	@Before
	public void setUp() {
		impl = new RegisterCustomerImpl();
	}
	
	@Test
	public void testCustomerRegistration() {
		assertEquals(impl.registerCustomer(), "customer found!");
	}

}
