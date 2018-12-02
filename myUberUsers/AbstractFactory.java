package myUberUsers;

public interface AbstractFactory {
	public Driver createADriver(String name,String surname);
	public Car createACar(String carType) throws CarTypeDoesntExistException;
	public Customer createACustomer (String name, String surname);
	}
