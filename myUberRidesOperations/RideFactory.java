package myUberRidesOperations;
import java.util.ArrayList;
import java.util.Calendar;

import myUberCalculs.Position;
import myUberCalculs.Prices;
import myUberCalculs.TrafficState;
import myUberUsers.Customer;
import myUberUsers.DistanceSorting;


public class RideFactory {
	
	
	static RideManager poolList;
	
	/**
	 * This method displays the prices for each type of ride according to the customer ride request parameters, 
	 * then, after the customer choose a ride type, calls the ride manager to launch and do the ride
	 * @param customer the customer of the ride request
	 * @param destination the destination the customer wants to get to
	 */
	public static synchronized void createARide(Customer customer,Position destination){
		Calendar calendar = Calendar.getInstance();
		TrafficState trafficState = TrafficState.getTrafficState(calendar);
		double length = customer.getPosition().calculateLength(destination);
		//MyUber calculate the different prices and display them to the customer
		Prices prices = new Prices(length, trafficState);
		System.out.println(prices);
		//the customer choose a ride type
		RideType rideType= customer.choose(prices);
		
		Calendar timeOfBooking = calendar;
		Ride ride=new Ride(destination,customer);
		ride.setTrafficState(trafficState);
		ride.setRideType(rideType);
		ride.setBookingTime(timeOfBooking);
				
			
		customer.setRideOnGoing(ride);
		if (rideType==RideType.UberPool){
			if(poolList==null){
				RideManager rideManager=new RideManager(new DistanceSorting(),new PoolRequest(ride));
				poolList=rideManager;
				rideManager.start();
			}
			else{
				synchronized(poolList.rideRequest){
					poolList.rideRequest.add(ride);
					poolList.rideRequest.notify();
				}
			}	
		}
		else{
			RideManager rideManager=new RideManager(new DistanceSorting(),ride);
			rideManager.start();
		}

	}
	
}

