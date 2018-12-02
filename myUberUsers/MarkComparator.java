package myUberUsers;
import java.util.Comparator;

public class MarkComparator implements Comparator<Driver> {

	
/**
 * This method has an error because we have not yet implemented the visitor pattern which will calculate the average mark
 */
	@Override
	public int compare(Driver o1, Driver o2) {
		AverageMarkVisitor visitor = new AverageMarkVisitor();
		return (int) (o1.accept(visitor)-o2.accept(visitor));	
	}
}
