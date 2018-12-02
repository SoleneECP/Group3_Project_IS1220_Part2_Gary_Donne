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
		assertTrue(TrafficState.getTrafficState(calendar)==TrafficState.lowTraffic || 
				TrafficState.getTrafficState(calendar)==TrafficState.mediumTraffic|| 
				TrafficState.getTrafficState(calendar)==TrafficState.heavyTraffic);
	}

}
