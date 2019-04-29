package com.senebii.order;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class OrderTest {
	@Test
	public void testId() {
		Order order = new Order(1);
		order.setId(3);
		assertEquals(3, order.getId());
	}

}
