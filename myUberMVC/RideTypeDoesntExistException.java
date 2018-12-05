package myUberMVC;

public class RideTypeDoesntExistException extends Exception {
	String rideTypeEntered;
	
	public RideTypeDoesntExistException(String string) {
		this.rideTypeEntered=string;
	}
}
