package myUberTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EnumMap;

import org.junit.jupiter.api.Test;

import myUberUsers.Driver;
import myUberUsers.DriverState;
import myUberUsers.OccupationRateVisitor;

class OccupationRateVisitorTest {

	@Test
	void testVisit() {
		Driver d = new Driver("Paul","Dupond");
		EnumMap<DriverState, Long> table = new EnumMap<DriverState, Long>(DriverState.class);
		table.put(DriverState.offDuty, (long) 1000);
		table.put(DriverState.onDuty, (long) 23000);
		table.put(DriverState.onARide, (long) 1000);
		table.put(DriverState.offline, (long)5000);
		d.setTableKPI(table);
		
		OccupationRateVisitor visitor = new OccupationRateVisitor();
		assertTrue(visitor.visit(d)==(double)(1000/23000));
	}
}
