package myUberTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.Test;

import myUberCalculs.TrafficState;

class TrafficStateTest {

	@Test
	void testGetAverageSpeed() {
		TrafficState trafficState = TrafficState.lowTraffic;
		assertTrue(trafficState.getAverageSpeed()==15);
	}

	@Test
	void testGetTrafficState() {
		Calendar calendar = Calendar.getInstance();
		TrafficState ts=TrafficState.getTrafficState(calendar);
		assertTrue(ts==TrafficState.lowTraffic|| 
				ts==TrafficState.mediumTraffic|| 
				ts==TrafficState.heavyTraffic);
	}

}
