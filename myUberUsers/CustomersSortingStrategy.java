package myUberUsers;
import java.util.ArrayList;

public interface CustomersSortingStrategy {
	
	default public ArrayList<Customer> sortCustomers(){
		return null;
	}

}
