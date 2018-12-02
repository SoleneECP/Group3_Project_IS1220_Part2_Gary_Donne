package myUberUsers;

public class CarFactory implements AbstractFactory {
	public Driver createADriver(String name,String surname) {return null;}
	
	public Customer createACustomer(String name, String surname) {return null;}
	public Car createACar(String carType) throws CarTypeDoesntExistException {
		switch(carType) {
		case "Standard":
			return new Car(CarType.Standard);
		case "Berline":
			return new Car(CarType.Berline);
		case "Van":
			return new Car(CarType.Van);
		default:
			throw new CarTypeDoesntExistException(carType);
		}
	}
	}
