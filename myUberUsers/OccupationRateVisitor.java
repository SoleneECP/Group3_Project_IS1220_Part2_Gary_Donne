package myUberUsers;

import java.util.Iterator;
import java.util.Map.Entry;

public class OccupationRateVisitor implements DriversOperationVisitor{

	@Override
	public double visit(Driver driver) {
		
		double timeOnARide = 0;
		double timeOnDuty = 0;
		for ( Entry<DriverState, Long> entry :driver.getTableKPI().entrySet()) {
			 if (entry.getKey()==DriverState.onARide) { timeOnARide=entry.getValue(); }
			 else if (entry.getKey() == DriverState.onDuty) { timeOnDuty=entry.getValue(); }
		}
		return (double)timeOnARide/timeOnDuty;
	}
	


}
