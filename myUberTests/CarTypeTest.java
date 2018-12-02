package myUberTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myUberUsers.CarType;

class CarTypeTest {

	

	@Test
	void testGetCarCapacity() {
		CarType carType = CarType.Berline;
		assertTrue(carType.getCarCapacity()==4);
	}
	

	@Test
	void testToString() {
		CarType carType = CarType.Van;
		assertTrue(carType.toString()=="[Van]");
	}

}
