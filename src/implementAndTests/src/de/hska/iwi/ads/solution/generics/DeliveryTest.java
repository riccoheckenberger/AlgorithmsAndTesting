package de.hska.iwi.ads.solution.generics;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;

import de.hska.iwi.ads.generics.Address;
import de.hska.iwi.ads.generics.Box;
import de.hska.iwi.ads.generics.Pizza;

class DeliveryTest {
	
	private Delivery<Pizza> del = new Delivery<>();
	private Address address = new Address("101");
	private Cardbox<Pizza> b = new Cardbox<>(10, new Pizza("TestPizza"));

	@Test
	void returnBox1() {
		del.addBox(b, address);
		assertTrue(del.deliver(address).contains(b));
		assertEquals(0, del.getFoodBoxes().size());
	}
	
	
	@Test
	void returnBox2() {
		Cardbox<Pizza> b2 = new Cardbox<>(20, new Pizza("TestPizza2"));
		del.addBox(b2, address);
		del.addBox(b, address);
		Set<Box<Pizza>> set = del.deliver(address);
		assertTrue(set.contains(b));
		assertTrue(set.contains(b2));
		assertEquals(2,set.size());
		assertEquals(0, del.getFoodBoxes().size());
	}
	
	@Test
	void returnBox3() {
		Cardbox<Pizza> b2 = new Cardbox<>(10, new Pizza("Test Pizza2"));
		Address address2 = new Address("202");
		del.addBox(b2, address2);
		del.addBox(b, address);
		Set<Box<Pizza>> set = del.deliver(address2);
		assertFalse(set.contains(b));
		assertTrue(set.contains(b2));
		assertEquals(1,set.size());
		assertEquals(1, del.getFoodBoxes().size());
		assertTrue(del.deliver(address).contains(b));
	}

}
