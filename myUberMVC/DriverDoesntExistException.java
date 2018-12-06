package myUberMVC;

public class DriverDoesntExistException extends Exception {
	String name;
	String surname;
	
	public DriverDoesntExistException(String name,String surname) {
		this.name=name;
		this.surname=surname;
	}
}
