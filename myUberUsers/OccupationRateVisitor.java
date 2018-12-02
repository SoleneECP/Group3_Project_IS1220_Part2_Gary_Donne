package myUberUsers;

import java.util.Iterator;
import java.util.Map.Entry;

public class OccupationRateVisitor implements DriversOperationVisitor{

	@Override
	public double visit(Driver driver) {
		
		double timeOnARide = 0;
		double timeOnDuty = 0;
		for ( Iterator i = driver.getTableKPI().entrySet().iterator(); i.hasNext();) {
			 Entry couple = (Entry)i.next();
			 DriverState driverState = (DriverState)couple.getKey();
			 Double time = (Double)couple.getValue();
			 if (driverState ==DriverState.onARide) { timeOnARide=time; }
			 else if (driverState == DriverState.onDuty) { timeOnDuty=time; }
		}
		return (double)timeOnARide/timeOnDuty;
	}
	


}
