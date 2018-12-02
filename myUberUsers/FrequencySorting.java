package myUberUsers;
import java.util.ArrayList;
import java.util.Collections;

public class FrequencySorting implements CustomersSortingStrategy{
	
	/**
	 * Sort the customers according to the total time spent into a Uber car for all completed rides
	 * @return an ArrayList of customer sorted from the most frequent customer to the least one
	 */
	@Override
	public ArrayList<Customer> sortCustomers (){
		ArrayList<Customer> sortedCustomers = new ArrayList<Customer>();
		for(Customer c : MyUberPopulation.getCustomers()) {
			sortedCustomers.add(c);
		}
		CustomerNumberOfRidesComparator timecomp = new CustomerNumberOfRidesComparator();
		Collections.sort(sortedCustomers, timecomp);
		return sortedCustomers;
	}

}
