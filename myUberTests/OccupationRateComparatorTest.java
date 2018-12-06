package myUberTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EnumMap;

import org.junit.jupiter.api.Test;

import myUberUsers.Driver;
import myUberUsers.DriverState;
import myUberUsers.OccupationRateComparator;

class OccupationRateComparatorTest {

	@Test
	void testCompare() {
		Driver d1 = new Driver("Jean","Dupont");
		Driver d2 = new Driver("Paul","Durand");
		
		EnumMap<DriverState, Long> table1 = new EnumMap<DriverState, Long>(DriverState.class);
		table1.put(DriverState.offDuty, (long) 1000);
		table1.put(DriverState.onDuty, (long) 23000);
		table1.put(DriverState.onARide, (long) 1000);
		table1.put(DriverState.offline, (long)5000);
		d1.setTableKPI(table1);
		
		EnumMap<DriverState, Long> table2 = new EnumMap<DriverState, Long>(DriverState.class);
		table2.put(DriverState.offDuty, (long) 1000);
		table2.put(DriverState.onDuty, (long) 23000);
		table2.put(DriverState.onARide, (long) 2000);
		table2.put(DriverState.offline, (long)5000);
		d2.setTableKPI(table2);
		
		OccupationRateComparator comp = new OccupationRateComparator();
		assertTrue(comp.compare(d1, d2)<0);
	}

}
