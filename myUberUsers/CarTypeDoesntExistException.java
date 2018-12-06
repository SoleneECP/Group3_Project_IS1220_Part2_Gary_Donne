package myUberUsers;

public class CarTypeDoesntExistException extends Exception {
	static final long serialversionUID=342;
	public String carType;
	
	public CarTypeDoesntExistException(String carType) {
		this.carType=carType;
	}
}
