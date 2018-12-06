package myUberTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myUberUsers.CarFactory;
import myUberUsers.CarType;
import myUberUsers.CarTypeDoesntExistException;

class CarFactoryTest {

	@Test
	void testCreateACar() throws CarTypeDoesntExistException {
		CarFactory factory = new CarFactory();
		assertTrue(factory.createACar("Berline").getCarType()==CarType.Berline);
	}

}
