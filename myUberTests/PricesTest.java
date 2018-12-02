package myUberTests;

import static org.junit.jupiter.api.Assertions.*;
import java.util.EnumMap;

import org.junit.jupiter.api.Test;

import myUberCalculs.Prices;
import myUberCalculs.TrafficState;
import myUberRidesOperations.RideType;

class PricesTest {

	@Test
	void testPrices() {
		Prices prices = new Prices(10.0, TrafficState.lowTraffic);
		assertTrue(prices.prices.get(RideType.UberPool)==Prices.getPrice(RideType.UberPool, 10.0,TrafficState.lowTraffic));
	}

	@Test
	void testGetPrice() {
		assertTrue(Prices.getPrice(RideType.UberX, 12, TrafficState.mediumTraffic)==25.212);
	}

	@Test
	void testGetBasicRate() {
		assertTrue(Prices.getBasicRate(RideType.UberBlack, 8.7)==5.5);
	}

	@Test
	void testGetTrafficRate() {
		assertTrue(Prices.getTrafficRate(RideType.UberVan,TrafficState.heavyTraffic )==1.8);
	}

}
