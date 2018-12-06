package myUberUsers;
import java.util.Comparator;

public class CustomerChargesComparator implements Comparator<Customer> {

	@Override
	public int compare(Customer o1, Customer o2) {
		return Double.compare(o1.getAmountOfCharges(),o2.getAmountOfCharges());
	}

}
