package myUberTests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myUberCalculs.Position;
import myUberUsers.Customer;
import myUberUsers.CustomerChargesComparator;

class CustomerChargesComparatorTest {

	@Test
	void testCompare() {
		Position pos = new Position(1,1);
		Customer c1 = new Customer(pos);
		Customer c2 = new Customer(pos);
		c1.setAmountOfCharges(13);
		c2.setAmountOfCharges(44);
		CustomerChargesComparator chargecomp = new CustomerChargesComparator();
		assertTrue(chargecomp.compare(c1, c2)==-31);
	}

}
