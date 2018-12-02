package myUberUsers;

public class CarTypeDoesntExistException extends Exception {
	static final long serialversionUID=342;
	String carType;
	
	public CarTypeDoesntExistException(String carType) {
		this.carType=carType;
	}
}
