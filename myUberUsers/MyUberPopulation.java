package myUberUsers;
import java.util.ArrayList;

public class MyUberPopulation {
	
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
	 * MyUberPopulation constructor 
	 * @param drivers All the drivers of MyUber
	 * @param customers All the customers of MyUber
	 * @param cars All the cars of MyUber
	 */
	public MyUberPopulation (ArrayList<Driver> drivers, ArrayList<Customer> customers, ArrayList<Car> cars) {
		MyUberPopulation.drivers=drivers;
		MyUberPopulation.customers=customers;
		MyUberPopulation.cars=cars;
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
		MyUberPopulation.drivers = drivers;
	}

	public static void setCustomers(ArrayList<Customer> customers) {
		MyUberPopulation.customers = customers;
	}

	public static void setCars(ArrayList<Car> cars) {
		MyUberPopulation.cars = cars;
	}
	

}
