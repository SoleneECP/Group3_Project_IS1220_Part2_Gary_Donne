package myUberTests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myUberCalculs.Position;
import myUberUsers.Customer;
import myUberUsers.CustomerNumberOfRidesComparator;

class CustomerNbOfRidesComparatorTest {

	@Test
	void testCompare() {
		Position pos = new Position(1,1);
		Customer c1 = new Customer(pos);
		Customer c2 = new Customer(pos);
		c1.setNbOfRides(29);
		c2.setNbOfRides(13);
		CustomerNumberOfRidesComparator nbcomp = new CustomerNumberOfRidesComparator();
		assertTrue(nbcomp.compare(c1, c2)==16);
	}

}
