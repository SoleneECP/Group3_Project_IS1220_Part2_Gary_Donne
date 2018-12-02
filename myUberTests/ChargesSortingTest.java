package myUberTests;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import myUberCalculs.Position;
import myUberUsers.ChargesSorting;
import myUberUsers.Customer;
import myUberUsers.MyUberPopulation;

class ChargesSortingTest {

	@Test
	void testSortMostChargedCustomer() {
		//creation of several customers and set their AmountOfCharges to then sort them according to this parameter and test if the sortCustomer() method is efficient 
		Position pos1 = new Position(1,1);
		Position pos2 = new Position(2,1);
		Position pos3 = new Position(1,3);
		Position pos4 = new Position(2,2);
		Customer c1 = new Customer(pos1);
		Customer c2 = new Customer(pos2);
		Customer c3 = new Customer(pos3);
		Customer c4 = new Customer(pos4);
		c1.setAmountOfCharges(66.1);
		c2.setAmountOfCharges(33);
		c3.setAmountOfCharges(25);
		c4.setAmountOfCharges(1.5);
		ArrayList<Customer> customers = new ArrayList<Customer>();
		customers.add(c1);
		customers.add(c2);
		customers.add(c3);
		customers.add(c4);
		MyUberPopulation.setCustomers(customers);
		ChargesSorting chargesSorting = new ChargesSorting();
		assertTrue(chargesSorting.sortCustomers().get(0).getPosition().equals(pos4));

	}

}
