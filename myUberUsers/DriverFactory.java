package myUberUsers;

public class DriverFactory implements AbstractFactory{
	public Car createACar(String carType) throws CarTypeDoesntExistException{return null;}
	public Customer createACustomer (String name, String surname) {return null;}
	public Driver createADriver(String name,String surname) {
		return new Driver(name,surname);
	}
}
