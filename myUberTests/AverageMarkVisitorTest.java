package myUberTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import myUberUsers.AverageMarkVisitor;
import myUberUsers.Driver;

class AverageMarkVisitorTest {

	@Test
	void testVisit() {
		Driver d = new Driver("Paul","Dupond");
		Map<Integer, Integer> marks1 = new HashMap<Integer, Integer>();
		marks1.put(1, 1);
		marks1.put(2, 2);
		marks1.put(3, 2);
		marks1.put(5, 10);
		d.setMarks(marks1);
		AverageMarkVisitor visitor = new AverageMarkVisitor();
		assertTrue((int)visitor.visit(d)==4);
	
	}

}
