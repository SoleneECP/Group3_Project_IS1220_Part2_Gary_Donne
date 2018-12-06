package myUberUsers;

import java.util.Iterator;
import java.util.Map.Entry;

public class AverageMarkVisitor implements DriversOperationVisitor{

	@Override
	public double visit(Driver driver) {
		double sumOfIterations = 0;
		double sumOfMarks = 0;
		for ( Entry<Integer, Integer> entry : driver.getMarks().entrySet()) {
			sumOfIterations +=entry.getValue();
			sumOfMarks+=entry.getKey()*entry.getValue();
		}
		return (double)sumOfMarks/sumOfIterations;
	}

}
