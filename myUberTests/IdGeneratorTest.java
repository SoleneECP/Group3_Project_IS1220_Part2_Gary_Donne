package myUberTests;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import myUberUsers.CarType;
import myUberUsers.IdGenerator;

class IdGeneratorTest {
	
	@Before
	public void resetSingleton() throws SecurityException, NoSuchFieldException, IllegalAccessException {
		Field instance = IdGenerator.class.getDeclaredField("instance");
		instance.setAccessible(true);
		instance.set(null, null);
	}
	

	@Test
	void testGetNextCarId() {
		IdGenerator idgencar1 = IdGenerator.getInstance();
		IdGenerator idgencar2 = IdGenerator.getInstance();
		String id1 = idgencar1.getNextCarId(CarType.Standard);
		String id2 = idgencar2.getNextCarId(CarType.Berline);
		assertTrue(id1.equals("Standard1") && id2.equals("Berline2"));
	}

	@Test
	void testGetNextCustomerId() {
		IdGenerator idgencust1 = IdGenerator.getInstance();
		IdGenerator idgencust2 = IdGenerator.getInstance();
		int id1 = idgencust1.getNextCustomerId();
		int id2 = idgencust2.getNextCustomerId();
		assertTrue(id1==1 && id2==2);
	}

	@Test
	void testGetNextDriverId() {
		IdGenerator idgendriv1 = IdGenerator.getInstance();
		IdGenerator idgendriv2 = IdGenerator.getInstance();
		int id1 = idgendriv1.getNextDriverId();
		int id2 = idgendriv2.getNextDriverId();
		assertTrue(id1==1 && id2==2);
	}

}
