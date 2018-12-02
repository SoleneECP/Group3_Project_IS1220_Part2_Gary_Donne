package myUberUsers;
import java.util.ArrayList;
import java.util.Collections;

public class OccupationRateStrategy implements DriversSortingStrategy {
	
	/**
	 * Sort the drivers according to the occupation rate of the drivers
	 * @return an ArrayLis of driver sorted from the least occupied driver to the most one
	 */
	
	public ArrayList<Driver> sortDriver(){
		ArrayList<Driver> sortedDrivers = new ArrayList<Driver>();
		for(Driver d : MyUberPopulation.getDrivers()) {
			sortedDrivers.add(d);
		}
		OccupationRateComparator occupationcomp = new OccupationRateComparator();
		Collections.sort(sortedDrivers, occupationcomp);
		return sortedDrivers;
	}

}
