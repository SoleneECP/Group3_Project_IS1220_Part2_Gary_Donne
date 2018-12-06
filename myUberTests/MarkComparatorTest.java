package myUberTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import myUberUsers.Driver;
import myUberUsers.MarkComparator;

class MarkComparatorTest {

	@Test
	void testCompare() {
		Driver d1 = new Driver("Jean","Dupont");
		Driver d2 = new Driver("Paul","Durand");
		
		Map<Integer, Integer> marks1 = new HashMap<Integer, Integer>();
		Map<Integer, Integer> marks2 = new HashMap<Integer, Integer>();
		
		marks1.put(1, 1);
		marks1.put(2, 2);
		marks1.put(3, 2);
		marks1.put(5, 10);
		
		marks2.put(1, 6);
		marks2.put(2, 10);
		marks2.put(4, 3);
		
		d1.setMarks(marks1);
		d2.setMarks(marks2);
		
		MarkComparator comp = new MarkComparator();
		assertTrue(comp.compare(d1, d2)>0);

		
	}

}
