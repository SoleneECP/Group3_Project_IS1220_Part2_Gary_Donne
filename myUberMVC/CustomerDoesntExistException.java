package myUberMVC;

public class CustomerDoesntExistException extends Exception {
	int custId;
	
	public CustomerDoesntExistException (int custId) {
		this.custId = custId;
	}
}
