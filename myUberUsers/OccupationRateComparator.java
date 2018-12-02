package myUberUsers;
import java.util.Comparator;

public class OccupationRateComparator implements Comparator<Driver>{

	
	/**
	 * This method has an error because we have not yet implemented the visitor pattern which willcalculate the occupation rate of a driver
	 */
	@Override
	public int compare(Driver o1, Driver o2) {
		return (int) o1.calculateOccupationRate()-o2.calculateOccupationRate();
	}
	
	

}
