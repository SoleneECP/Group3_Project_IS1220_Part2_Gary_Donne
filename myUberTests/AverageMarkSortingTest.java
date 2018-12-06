package myUberTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import myUberCalculs.Position;
import myUberUsers.AverageMarkSorting;
import myUberUsers.Car;
import myUberUsers.CarType;
import myUberUsers.Customer;
import myUberUsers.Driver;
import myUberUsers.MyUberPopulation;

class AverageMarkSortingTest {

	@Test
	void testSortDriver() {
		Driver d1 = new Driver("Paul","Dupond");
		Driver d2 = new Driver("Jean","Durand");
		Driver d3 = new Driver("Marie","Lefevre");
		
		Map<Integer, Integer> marks1 = new HashMap<Integer, Integer>();
		Map<Integer, Integer> marks2 = new HashMap<Integer, Integer>();
		Map<Integer, Integer> marks3 = new HashMap<Integer, Integer>();

		marks1.put(1, 1);
		marks1.put(2, 2);
		marks1.put(3, 2);
		marks1.put(5, 10);
		
		marks2.put(1, 6);
		marks2.put(2, 10);
		marks2.put(4, 3);
		
		marks3.put(1, 1);
		marks3.put(2, 1);
		marks3.put(4, 10);
		
		d1.setMarks(marks1);
		d2.setMarks(marks2);
		d3.setMarks(marks2);

		ArrayList<Driver> drivers = new ArrayList<Driver>();
		drivers.add(d1);
		drivers.add(d2);
		drivers.add(d3);
		
		Position p1 = new Position(1,1);
		Position p2 = new Position(2,2);
		Customer c = new Customer(p1);
		Car car = new Car(CarType.Standard, p2);
		ArrayList<Customer> cust = new ArrayList<Customer>();
		ArrayList<Car> cars = new ArrayList<Car>();
		cust.add(c);
		cars.add(car);
		
		MyUberPopulation population = new MyUberPopulation(drivers, cust, cars);
		AverageMarkSorting sorting = new AverageMarkSorting();
		
		assertTrue(sorting.sortDriver().get(0).getDriverName().equalsIgnoreCase("Jean"));

	}

}
