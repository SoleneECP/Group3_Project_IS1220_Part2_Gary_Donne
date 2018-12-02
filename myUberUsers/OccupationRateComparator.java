package myUberUsers;
import java.util.Comparator;

public class OccupationRateComparator implements Comparator<Driver>{

	
	/**
	 * This method has an error because we have not yet implemented the visitor pattern which willcalculate the occupation rate of a driver
	 */
	@Override
	public int compare(Driver o1, Driver o2) {
		OccupationRateVisitor visitor = new OccupationRateVisitor();
		return (int)( o1.accept(visitor)-o2.accept(visitor));	
	}
	
}
