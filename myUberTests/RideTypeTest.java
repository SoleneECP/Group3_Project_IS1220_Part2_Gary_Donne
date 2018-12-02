package myUberTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myUberRidesOperations.RideType;
import myUberUsers.CarType;

class RideTypeTest {

	@Test
	void testGetCompatibleCarType() {
		RideType rideType = RideType.UberPool;
		assertTrue(rideType.getCompatibleCarType()==CarType.Standard);
	}

}
