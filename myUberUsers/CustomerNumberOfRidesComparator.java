package myUberUsers;
import java.util.Comparator;

public class CustomerNumberOfRidesComparator implements Comparator<Customer> {

	@Override
	public int compare(Customer o1, Customer o2) {
		return (int) (o1.getNbOfRides()-o2.getNbOfRides());
	}

}
