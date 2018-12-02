package myUberTests;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import myUberCalculs.Position;
import myUberRidesOperations.PoolRequest;
import myUberRidesOperations.Ride;
import myUberRidesOperations.RideRequest;
import myUberUsers.Car;
import myUberUsers.CarType;
import myUberUsers.Customer;
import myUberUsers.DistanceSorting;
import myUberUsers.Driver;
import myUberUsers.DriverState;
import myUberUsers.MyUberPopulation;

class DistanceSortingTest {
	
	/**
	 * Test the sortNearestDrivers method
	 */
	@Test
	void testSortDrivers() {
		//The starting positions of the 3 customers of a pool request
		Position c1pos = new Position(1,2);
		Position c2pos = new Position(1,5);
		Position c3pos = new Position(1,3);
		//The destinations of the 3 customers of a pool request
		Position c1dest = new Position(3,1);
		Position c2dest = new Position(4,1);
		Position c3dest = new Position(2,1);
		//The 3 customers of a pool request
		Customer c1 = new Customer(c1pos);
		Customer c2 = new Customer(c2pos);
		Customer c3 = new Customer(c3pos);
		//The 3 ride of a pool request 
		Ride ride1 = new Ride(c1dest,c1);
		Ride ride2 = new Ride(c2dest,c2);
		Ride ride3 = new Ride(c3dest, c3);
		//create the pool request composed of the three rides
		RideRequest rideRequest = new PoolRequest(ride1);
		rideRequest.add(ride2);
		rideRequest.add(ride3);
		//The positions of 3 cars
		Position carpos1 = new Position(1,1);
		Position carpos2 = new Position(2,1);
		Position carpos3 = new Position(5,1);
		Car car1 = new Car(CarType.Standard, carpos1);
		Car car2 = new Car(CarType.Standard, carpos2);
		Car car3 = new Car(CarType.Standard, carpos3);
		//The drivers who ride the 3 cars
		Driver driver1 = new Driver("Paul","Dupond", car1, DriverState.onDuty);
		Driver driver2 = new Driver("Pierre","Durand",car2, DriverState.onDuty);
		Driver driver3 = new Driver("Jean","Moulin",car3, DriverState.onDuty);
		//create the MyUberPopulation 
		ArrayList<Driver> drivers = new ArrayList<Driver>();
		ArrayList<Customer> customers = new ArrayList<Customer>();
		ArrayList<Car> cars = new ArrayList<Car>();
		drivers.add(driver1);
		drivers.add(driver2);
		drivers.add(driver3);
		customers.add(c1);
		customers.add(c2);
		customers.add(c3);
		cars.add(car1);
		cars.add(car2);
		cars.add(car3);
		MyUberPopulation population = new MyUberPopulation(drivers, customers, cars);
		
		DistanceSorting poolSorting = new DistanceSorting();
		assertTrue(poolSorting.sortDrivers(rideRequest).get(0).getDriverName()=="Paul");

	}

	
/**
 * test the trajectorycost method
 */
	@Test
	void testTrajectorycost() {
		//The position of a car
		Position carpos = new Position(1,1);
		//The starting position of 3 customers
		Position c1pos = new Position(1,2);
		Position c2pos = new Position(1,5);
		Position c3pos = new Position(1,3);
		//The destination of 3 customers
		Position c1dest = new Position(3,1);
		Position c2dest = new Position(4,1);
		Position c3dest = new Position(1,1);
		
		Car car = new Car(CarType.Standard, carpos);
		//The driver riding the car
		Driver driver = new Driver("Paul","Dupond",car, DriverState.onDuty);
		//The 3 customers
		Customer c1 = new Customer(c1pos);
		Customer c2 = new Customer(c2pos);
		Customer c3 = new Customer(c3pos);
		//The 3 ride of a pool request
		Ride ride1 = new Ride(c1dest,c1);
		Ride ride2 = new Ride(c2dest,c2);
		Ride ride3 = new Ride(c3dest, c3);
		RideRequest rideRequest = new PoolRequest(ride1);
		rideRequest.add(ride2);
		rideRequest.add(ride3);
		DistanceSorting poolSorting = new DistanceSorting();
		assertTrue(poolSorting.trajectorycost(driver, rideRequest)==11);

	}
	
	@Test
	public void SortDrivesWhenUniqueRide(){
		Position c1pos = new Position(1,2);
		Position c1dest = new Position(3,1);
		Customer c1 = new Customer(c1pos);
		Ride ride1 = new Ride(c1dest,c1);
		RideRequest rideRequest = new PoolRequest(ride1);
		Position carpos1 = new Position(1,1);
		Position carpos2 = new Position(2,1);
		Position carpos3 = new Position(5,1);
		Car car1 = new Car(CarType.Standard, carpos1);
		Car car2 = new Car(CarType.Standard, carpos2);
		Car car3 = new Car(CarType.Standard, carpos3);
		Driver driver1 = new Driver("Paul","Dupond", car1, DriverState.onDuty);
		Driver driver2 = new Driver("Pierre","Durand",car2, DriverState.onDuty);
		Driver driver3 = new Driver("Jean","Moulin",car3, DriverState.onDuty);
		ArrayList<Driver> drivers = new ArrayList<Driver>();
		ArrayList<Customer> customers = new ArrayList<Customer>();
		ArrayList<Car> cars = new ArrayList<Car>();
		drivers.add(driver1);
		drivers.add(driver2);
		drivers.add(driver3);
		customers.add(c1);
		cars.add(car1);
		cars.add(car2);
		cars.add(car3);
		MyUberPopulation population = new MyUberPopulation(drivers, customers, cars);
		
		DistanceSorting poolSorting = new DistanceSorting();
		assertTrue(poolSorting.sortDrivers(rideRequest).get(0).getDriverName()=="Paul");
	}

}
