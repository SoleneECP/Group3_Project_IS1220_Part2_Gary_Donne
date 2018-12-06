package myUberTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myUberUsers.DriverFactory;

class DriverFactoryTest {

	@Test
	void testCreateADriver() {
		DriverFactory factory = new DriverFactory();
		assertTrue(factory.createADriver("Dupond", "Paul").getSurname()=="Paul");
		
	}

}
