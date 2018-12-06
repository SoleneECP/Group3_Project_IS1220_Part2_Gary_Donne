package myUberTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.EnumMap;

import org.junit.jupiter.api.Test;

import myUberUsers.Car;
import myUberUsers.CarType;
import myUberUsers.Customer;
import myUberUsers.Driver;
import myUberUsers.DriverState;
import myUberUsers.MyUberPopulation;
import myUberUsers.OccupationRateStrategy;

class OccupationRateStrategyTest {

	@Test
	void testSortDriver() {
		Driver d1 = new Driver("Dupond","Paul");
		EnumMap<DriverState, Long> table1 = new EnumMap<DriverState, Long>(DriverState.class);
		table1.put(DriverState.offDuty, (long) 1000);
		table1.put(DriverState.onDuty, (long) 23000);
		table1.put(DriverState.onARide, (long) 1000);
		table1.put(DriverState.offline, (long)5000);
		d1.setTableKPI(table1);	
		
		Driver d2 = new Driver("Durand","Jean");
		EnumMap<DriverState, Long> table2 = new EnumMap<DriverState, Long>(DriverState.class);
		table2.put(DriverState.offDuty, (long) 1000);
		table2.put(DriverState.onDuty, (long) 23000);
		table2.put(DriverState.onARide, (long) 2000);
		table2.put(DriverState.offline, (long)5000);
		d2.setTableKPI(table2);	
		
		Driver d3 = new Driver("Lefevre","Pierre");
		EnumMap<DriverState, Long> table3 = new EnumMap<DriverState, Long>(DriverState.class);
		table3.put(DriverState.offDuty, (long) 1000);
		table3.put(DriverState.onDuty, (long) 23000);
		table3.put(DriverState.onARide, (long) 3000);
		table3.put(DriverState.offline, (long)5000);
		d3.setTableKPI(table3);	
		
		Customer cust = new Customer("Dupond","Paul");
		Car car = new Car(CarType.Standard);
		ArrayList<Driver> drivers = new ArrayList<Driver>();
		ArrayList<Customer> customers = new ArrayList<Customer>();
		ArrayList<Car> cars = new ArrayList<Car>();
		drivers.add(d1);
		drivers.add(d2);
		drivers.add(d3);
		customers.add(cust);
		cars.add(car);
		
		MyUberPopulation population = new MyUberPopulation(drivers, customers, cars);
		
		OccupationRateStrategy sorting = new OccupationRateStrategy();
		assertTrue(sorting.sortDriver().get(0).getSurname()=="Paul");
		
	}

}
