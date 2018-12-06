package myUberTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myUberUsers.CustomerFactory;

class CustomerFactoryTest {

	@Test
	void testCreateACustomer() {
		CustomerFactory factory = new CustomerFactory();
		assertTrue(factory.createACustomer("Dupond", "Paul").getSurname()=="Paul");
	}

}
