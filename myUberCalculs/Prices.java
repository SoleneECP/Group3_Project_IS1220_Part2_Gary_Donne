package myUberCalculs;

import java.util.EnumMap;
import java.util.TreeMap;

import myUberRidesOperations.RideType;

public class Prices {
	
	/**
	 * the map with the price according to the type of ride for a ride request
	 */
	
	EnumMap<RideType, Double> prices;
	
	
	/**
	 * create an object Prices with the price according to the type of ride for a ride request
	 * @param length the distance between the initial position and the destination of the customer
	 * @param trafficState the traffic state at the ride request 
	 */
	
	public Prices (double length, TrafficState  trafficState){
		prices=new EnumMap<RideType, Double>(RideType.class);
		for (RideType e : RideType.values()) {
			prices.put(e,getPrice(e, length, trafficState));
		}
	}
	
	
	
	/**
	 * get the price of a ride 
	 * @param rideType the type of ride 
	 * @param length the distance between the initial position and the destination of the customer
	 * @param trafficState the traffic state at the ride request
	 * @return the price of a ride
	 */
	
	public static double getPrice (RideType rideType, double length, TrafficState trafficState ) {
		double basicRate = getBasicRate (rideType, length);
		double trafficRate = getTrafficRate(rideType, trafficState);
		return length*basicRate*trafficRate;
	}
	
	
	/**
	 * get the basic rate for a ride in Euro/Km
	 * @param rideType the type of ride 
	 * @param length the distance between the initial position and the destination of the customer
	 * @return the basic rate for a ride 
	 */
	
	public static double getBasicRate (RideType rideType, double length) {
		if (rideType==RideType.UberX) {
			if (length<=5) {return 3.3;}
			else if (5<length && length<=10) {return 4.2;}
			else if (10<length && length<=20) {return 1.91;}
			else {return 1.5;}
		}
		else if (rideType==RideType.UberBlack) {
			if (length<=5) {return 6.2;}
			else if (5<length && length<=10) {return 5.5;}
			else if (10<length && length<=20) {return 3.25;}
			else {return 2.6;}
		}
		else if (rideType==RideType.UberPool) {
			if (length<=5) {return 2.4;}
			else if (5<length && length<=10) {return 3;}
			else if (10<length && length<=20) {return 1.3;}
			else {return 1.1;}
		}
		else {
			if (length<=5) {return 6.2;}
			else if (5<length && length<=10) {return 7.7;}
			else if (10<length && length<=20) {return 3.25;}
			else {return 2.6;}
		}
	}
	
	/**
	 * get the Traffic Rate 
	 * @param rideType the type of ride
	 * @param trafficState the traffic state at the ride request
	 * @return the Traffic Rate
	 */
	
	public static double getTrafficRate (RideType rideType, TrafficState trafficState) {
		if (rideType==RideType.UberX) {
			if (trafficState==TrafficState.lowTraffic) {return 1;}
			else if (trafficState==TrafficState.mediumTraffic) {return 1.1;}
			else  {return 1.5;}
		}
		else if (rideType==RideType.UberBlack) {
			if (trafficState==TrafficState.lowTraffic) {return 1;}
			else if (trafficState==TrafficState.mediumTraffic) {return 1.3;}
			else  {return 1.6;}
		}
		else if (rideType==RideType.UberPool) {
			if (trafficState==TrafficState.lowTraffic) {return 1;}
			else if (trafficState==TrafficState.mediumTraffic) {return 1.1;}
			else  {return 1.2;}
		}
		else {
			if (trafficState==TrafficState.lowTraffic) {return 1;}
			else if (trafficState==TrafficState.mediumTraffic) {return 1.5;}
			else  {return 1.8;}
		}
	}

}
