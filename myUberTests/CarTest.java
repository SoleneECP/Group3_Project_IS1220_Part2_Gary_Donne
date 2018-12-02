package myUberTests;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import myUberCalculs.Position;
import myUberUsers.Car;
import myUberUsers.CarType;

class CarTest {

	@Test
	void testGetPosition() {
		Position carpos = new Position(3,5);
		Car car = new Car(CarType.Berline, carpos);
		assertTrue(car.getPosition()==carpos);
	}

	@Test
	void testGetCarType() {
		Position carpos = new Position(3,5);
		Car car = new Car(CarType.Berline, carpos);
		assertTrue(car.getCarType()==CarType.Berline);
		}

	@Test
	void testGetId() {
		Position carpos = new Position(3,5);
		Car car = new Car(CarType.Berline, carpos);
		assertTrue(car.getId().equals("Berline1"));
	}

	@Test
	void testSetPosition() {
		Position carpos = new Position(3,5);
		Car car = new Car(CarType.Berline, carpos);
		Position carnewpos = new Position(2,3);
		car.setPosition(carnewpos);
		assertTrue(car.getPosition()==carnewpos);
	}

}
