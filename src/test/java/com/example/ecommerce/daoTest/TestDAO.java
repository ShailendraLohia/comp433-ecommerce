package com.example.ecommerce.daoTest;

import static org.junit.Assert.*;
import com.example.ecommerce.dal.customer.DAOImpl;

import org.junit.Before;
import org.junit.Test;

public class TestDAO {

	DAOImpl dao;
	
	@Before
	public void setUp() {
		dao = new DAOImpl();
	}
	
	@Test
	public void testFindCustomer() {
		assertEquals(dao.findCustomer(), "customer found!");
	}

}
