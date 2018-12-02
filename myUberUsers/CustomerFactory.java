package myUberUsers;

public class CustomerFactory implements AbstractFactory {
	public Driver createADriver(String name,String surname) {return null;}
	public Car createACar(String carType) throws CarTypeDoesntExistException{return null;}
	public Customer createACustomer (String name, String surname) {
		return new Customer(name,surname);
	}
}
