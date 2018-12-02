package myUberTests;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import myUberCalculs.Position;
import myUberUsers.Customer;
import myUberUsers.FrequencySorting;
import myUberUsers.MyUberPopulation;

class FrequencySortingTest {

	@Test
	void testSortCustomers() {
		Position pos1 = new Position(1,1);
		Position pos2 = new Position(2,1);
		Position pos3 = new Position(1,3);
		Position pos4 = new Position(2,2);
		Customer c1 = new Customer(pos1);
		Customer c2 = new Customer(pos2);
		Customer c3 = new Customer(pos3);
		Customer c4 = new Customer(pos4);
		c1.setNbOfRides(5);
		c2.setNbOfRides(10);
		c3.setNbOfRides(25);
		c4.setNbOfRides(7);
		ArrayList<Customer> customers = new ArrayList<Customer>();
		customers.add(c1);
		customers.add(c2);
		customers.add(c3);
		customers.add(c4);
		MyUberPopulation.setCustomers(customers);
		FrequencySorting timesorting = new FrequencySorting();
		assertTrue(timesorting.sortCustomers().get(0).getPosition().equals(pos1));
	}

}
