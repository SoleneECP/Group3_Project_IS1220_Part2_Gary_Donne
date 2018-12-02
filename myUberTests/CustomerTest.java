package myUberTests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myUberCalculs.Position;
import myUberCalculs.Prices;
import myUberCalculs.TrafficState;
import myUberRidesOperations.RideType;
import myUberUsers.Customer;

class CustomerTest {

	@Test
	void testGetARidePosition() {
		fail("Not yet implemented");
	}

	@Test
	void testAskForAMark() {
		Position pos = new Position(1,1);
		Customer c = new Customer (pos);
		assertTrue(c.askForAMark()>=0 && c.askForAMark()<=5);
	}

	@Test
	void testChoose() {
		Position pos = new Position(1,1);
		Customer c = new Customer (pos);
		Prices prices = new Prices(1,TrafficState.heavyTraffic);
		assertTrue(c.choose(prices)==RideType.UberBlack || c.choose(prices)==RideType.UberVan || c.choose(prices)==RideType.UberX || c.choose(prices)==RideType.UberPool);
	}

	@Test
	void testCharge() {
		Position pos = new Position(1,1);
		Customer c = new Customer (pos);
		c.setAmountOfCharges(3);
		c.charge(25.1);
		assertTrue(c.getAmountOfCharges()==28.1);
	}

}
