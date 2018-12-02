package myUberUsers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class AverageMarkSorting implements DriversSortingStrategy {

	/**
	 * Sort the drivers according to their mark given by their customers
	 * @return an ArrayListof driver sorted from the most appreciate driver (with the best marks : 5 stars) to the least one
	 */
	
	public ArrayList<Driver> sortDriver(){
		ArrayList<Driver> sortedDrivers = new ArrayList<Driver>();
		for(Driver d : MyUberPopulation.getDrivers()) {
			sortedDrivers.add(d);
		}
		MarkComparator markcomp = new MarkComparator();
		Collections.sort(sortedDrivers, markcomp);
		return sortedDrivers;
	}
	
	
	
}
