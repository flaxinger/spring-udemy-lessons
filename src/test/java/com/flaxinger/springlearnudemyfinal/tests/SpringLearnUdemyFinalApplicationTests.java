package com.flaxinger.springlearnudemyfinal.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertNotNull;

@SpringBootTest
class SpringLearnUdemyFinalApplicationTests {

	@Test
	void contextLoads() {

	}
	@Test
	@DisplayName("Check Value is Null")
	public void testDummy() {
		Long value = null;
		assertNotNull("Value Should not be Null", value);
	}
}
