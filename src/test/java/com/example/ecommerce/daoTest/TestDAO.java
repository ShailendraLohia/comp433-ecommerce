package com.example.ecommerce.daoTest;

import com.example.ecommerce.dal.customer.CustomerDAOImpl;

import org.junit.Before;

public class TestDAO {

	CustomerDAOImpl dao;
	
	@Before
	public void setUp() {
		dao = new CustomerDAOImpl();
	}
	
//	@Test
//	public void testFindCustomer() {
//		assertEquals(dao.findCustomer(), "customer found!");
//	}

}
