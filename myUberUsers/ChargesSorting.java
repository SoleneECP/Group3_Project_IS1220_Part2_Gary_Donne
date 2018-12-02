package myUberUsers;
import java.util.ArrayList;
import java.util.Collections;

public class ChargesSorting implements CustomersSortingStrategy{
	
	/**
	 * Sort the customers according to the total amount of charges for all completed rides
	 * @return an ArrayList of customer sorted from the most charged customer to the least one
	 */
	@Override
	public ArrayList<Customer> sortCustomers (){
		ArrayList<Customer> sortedCustomers = new ArrayList<Customer>();
		for (Customer c : MyUberPopulation.getCustomers()) {
			sortedCustomers.add(c);
		}
		CustomerChargesComparator chargecomp = new CustomerChargesComparator();
		Collections.sort(sortedCustomers, chargecomp);
		return sortedCustomers;
	}

}
