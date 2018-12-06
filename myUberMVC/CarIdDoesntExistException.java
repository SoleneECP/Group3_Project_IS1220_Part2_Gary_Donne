package myUberMVC;

public class CarIdDoesntExistException extends Exception {
	String carId;
	
	public CarIdDoesntExistException (String carId) {
		this.carId = carId;
	}

}
