package com.example.ecommerce.controllerTest;

import static org.junit.Assert.*;
import com.example.ecommerce.controller.HelloController;

import org.junit.Before;
import org.junit.Test;

public class TestController {
	
	HelloController controller;
	
	@Before
    public void setUp() {
		controller = new HelloController();
    }
	
	@Test
	public void testSayHello() {
		assertEquals(controller.sayHello(), "customer found!");
	}

}
