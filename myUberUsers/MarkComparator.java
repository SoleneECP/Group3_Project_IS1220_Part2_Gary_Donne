package myUberUsers;
import java.util.Comparator;

public class MarkComparator implements Comparator<Driver> {

	
/**
 * This method has an error because we have not yet implemented the visitor pattern which will calculate the average mark
 */
	@Override
	public int compare(Driver o1, Driver o2) {
		return (int) (o1.getMark()-o2.getMark());
	}
}
