package myUberMVC;


import myUberRidesOperations.RideType;

import java.util.ArrayList;

import myUberCalculs.Position;
import myUberCalculs.Prices;
import myUberCalculs.TrafficState;
import myUberRidesOperations.RideType;
import myUberUsers.Car;
import myUberUsers.CarFactory;
import myUberUsers.CarType;
import myUberUsers.CarTypeDoesntExistException;
import myUberUsers.Customer;
import myUberUsers.CustomerFactory;
import myUberUsers.Driver;
import myUberUsers.DriverFactory;
import myUberUsers.DriverState;
import myUberUsers.MyUberPopulation;

public class MyUberModel {
	/**
	 * All the drivers of MyUber
	 */
	public static ArrayList<Driver> drivers;
	
	/**
	 * All the customers of MyUber
	 */
	public static ArrayList<Customer> customers;
	
	/**
	 * All the cars of MyUber
	 */
	public static ArrayList<Car> cars;
	
	/**
	 * It initializes the Users of MyUber System with cars, customers and drivers
	 * @param nStandard the number of Standard cars to be created
	 * @param nBerlin the number of Berline cars to be created
	 * @param nVan the number of Van cars to be created
	 * @param nCustomers the number of customers to be created
	 */
	public MyUberModel(int nStandard, int nBerlin, int nVan, int nCustomers) {
		CarFactory carFactory = new CarFactory();
		DriverFactory driverFactory = new DriverFactory();
		CustomerFactory customerFactory = new CustomerFactory();
		try {
			for(int i=0; i<nStandard; i++) {
				Car car = carFactory.createACar("Standard");
				Driver d = driverFactory.createADriver("driver"+i+"name", "driver"+i+"surname");
				d.setCarUsed(car);
			}
			for(int i=0;i<nBerlin;i++) {
				Car car = carFactory.createACar("Berline");
				Driver d = driverFactory.createADriver("driver"+i+nStandard+"name", "driver"+i+nStandard+"surname");
				d.setCarUsed(car);
			}
			for(int i=0;i<nVan;i++) {
				Car car = carFactory.createACar("Van");
				Driver d = driverFactory.createADriver("driver"+i+nStandard+nBerlin+"name", "driver"+i+nStandard+nBerlin+"surname");
				d.setCarUsed(car);
			}
			for(int i=0;i<nCustomers;i++) {
				customerFactory.createACustomer("customer"+i+"name", "customer"+i+"surname");
			}
		}
		catch(CarTypeDoesntExistException e) {
			System.out.println("Exception is never reached.");
		}
	}
	
	/**
	 * It calculate the prices for a customer's ride request
	 * @param custId the unique Id of a customer
	 * @param xpos the x parameter of the position of the destination
	 * @param ypos the x parameter of the position of the destination
	 * @param time the hour of the time the ride should begin
	 */
	public void ask4price(int custId, int xpos, int ypos, int time)throws CustomerDoesntExistException {
		Customer cust = getCustomer(custId);
		double length = cust.getPosition().calculateLength(new Position(xpos,ypos));
		TrafficState trafficState = TrafficState.getTrafficState(time);
		Prices prices = new Prices(length, trafficState);
	}
	
	/**
	 * It updates the position of a car
	 * @param carId the unique ID of the car we want to move
	 * @param xpos the x parameter of the new position
	 * @param ypos the y parameter of the new position
	 */
	public void moveCar(String carId, int xpos, int ypos) throws CarIdDoesntExistException{
		Car car = getCar(carId);
		car.setPosition(new Position(xpos,ypos));
	}
	
	/**
	 * It updates the position of the customer
	 * @param custId the unique Id of the customer we want to move
	 * @param xpos the x parameter of the new position
	 * @param ypos the y parameter of the new position
	 */
	public void moveCustomer(int custId, int xpos, int ypos) throws CustomerDoesntExistException {
		Customer cust = getCustomer(custId);
		cust.setPosition(new Position(xpos,ypos));
	}
	
	/**
	 * It updates the status of the driver
	 * @param name the name of the driver
	 * @param surname the surname of the driver
	 * @param state the new status of the driver
	 */
	public void setDriverStatus(String name, String surname, DriverState state) throws DriverDoesntExistException{
		Driver d = getDriver(name, surname);
		d.setDriverState(state);
	}
	
	/**
	 * It creates and adds a customer to MyUber System
	 * @param name the name of the new customer
	 * @param surname the surname of the new customer
	 */
	public void addCustomer(String name, String surname) {
		CustomerFactory factory = new CustomerFactory();
		Customer c = factory.createACustomer(name, surname);
		customers.add(c);
	}
	
	/**
	 * It creates and adds a driver to MyUber System and associates it to an existing Car
	 * @param name the name of the new driver
	 * @param surname the surname of the new driver
	 * @param carId the unique Id of the existing car to be used by the new driver
	 */
	public void addDriver(String name, String surname, String carId) throws CarIdDoesntExistException{
		DriverFactory factory = new DriverFactory();
		Driver d = factory.createADriver(name, surname);
		d.setCarUsed(getCar(carId));
		drivers.add(d);
	}
	
	/**
	 * It creates and adds to MyUber System a new Car and a new Driver, initially offline, using this new car
	 * @param name the name of the new driver
	 * @param surname the surname of the new driver
	 * @param carType the type car of the new car
	 */
	public void addCarDriver(String name, String surname, String carType) {
		CarFactory carFact = new CarFactory();
		Car car;
		try {
			car = carFact.createACar(carType);
			MyUberPopulation.cars.add(car);
			DriverFactory driverfact = new DriverFactory();
			Driver d = driverfact.createADriver(name, surname);
			d.setCarUsed(car);
			d.setDriverState(DriverState.offline);
			drivers.add(d);
		} catch (CarTypeDoesntExistException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param custID the unique Id of the customer
	 * @param xdest the x parameter of the destination
	 * @param ydest the y parameter of the destination
	 * @param rideType the ride type 
	 * @param driverMark the mark of the driver given by the customer for this ride
	 * @throws CustomerDoesntExistException
	 */
	public void simRide(int custID, int xdest, int ydest, RideType rideType, int driverMark) throws CustomerDoesntExistException {
		Customer cust = getCustomer(custID);
		cust.getARide(new Position(xdest, ydest), rideType, driverMark);
	}
	
	/**
	 * 
	 * @param custID the unique Id of the customer
	 * @param xpos the x parameter of the destination
	 * @param ypos the y parameter of the destination
	 * @throws CustomerDoesntExistException
	 */
	public void simRide(int custID, int xpos, int ypos) throws CustomerDoesntExistException {
		Customer cust = getCustomer(custID);
		cust.getARide(new Position(xpos,ypos));
	}
	
	/**
	 * It gives the car of the corresponding unique Id
	 * @param carId the unique Id of the car
	 * @return the car of the corresponding unique Id
	 */
	public Car getCar(String carId) throws CarIdDoesntExistException{
		for(Car c : cars) {
			if(c.getId().equalsIgnoreCase(carId)) {return c;}
		}
		throw new CarIdDoesntExistException(carId);
	}
	/**
	 * It gives the customer of the corresponding unique Id
	 * @param custId the unique numerical Id of the customer 
	 * @return the customer of the corresponding unique Id
	 */
	public Customer getCustomer(int custId) throws CustomerDoesntExistException {
		for(Customer c : customers) {
			if(c.getId()==custId) {return c;}
		}
		throw new CustomerDoesntExistException(custId);
	}
	
	/**
	 * It gives the driver of the corresponding name and surname
	 * @param name the name of the driver
	 * @param surname the surname of the driver
	 * @return the driver of the corresponding name and surname
	 */
	public Driver getDriver(String name, String surname) throws DriverDoesntExistException{
		for(Driver d : drivers) {
			if(d.getDriverName().equalsIgnoreCase(name) && d.getSurname().equalsIgnoreCase(surname)) {
				return d;
			}
		}
		throw new DriverDoesntExistException(name,surname);
		
	}
	/**
	 * MyUberModel constructor 
	 * @param drivers All the drivers of MyUber
	 * @param customers All the customers of MyUber
	 * @param cars All the cars of MyUber
	 */
	public MyUberModel (ArrayList<Driver> drivers, ArrayList<Customer> customers, ArrayList<Car> cars) {
		MyUberModel.drivers=drivers;
		MyUberModel.customers=customers;
		MyUberModel.cars=cars;
	}


	public static ArrayList<Driver> getDrivers() {
		return drivers;
	}

	public static ArrayList<Customer> getCustomers() {
		return customers;
	}

	public static ArrayList<Car> getCars() {
		return cars;
	}
	
	/**
	 * Get the available drivers for a ride = the on-duty drivers
	 * @return the on-duty drivers
	 */
	public static ArrayList<Driver> getAvailableDrivers() {
		ArrayList<Driver> availableDrivers = new ArrayList<Driver>();
		for(Driver d : drivers) {
			if(d.getStatus()==DriverState.onDuty) {availableDrivers.add(d);}
		}
		return availableDrivers;
	}

	public static void setDrivers(ArrayList<Driver> drivers) {
		MyUberModel.drivers = drivers;
	}

	public static void setCustomers(ArrayList<Customer> customers) {
		MyUberModel.customers = customers;
	}

	public static void setCars(ArrayList<Car> cars) {
		MyUberModel.cars = cars;
	}
}
