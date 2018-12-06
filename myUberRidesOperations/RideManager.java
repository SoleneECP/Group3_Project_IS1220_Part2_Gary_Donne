package myUberRidesOperations;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import myUberCalculs.Position;
import myUberCalculs.TrafficState;
import myUberUsers.Driver;
import myUberUsers.DriverState;
import myUberUsers.DriversSortingStrategy;

public class RideManager extends Thread{
	
	/**
	 * The ride request 
	 */
	RideRequest rideRequest;
	
	/**
	 * The sorting strategy which sorts the drivers 
	 */
	DriversSortingStrategy sortingStrategy;
	
	
	/**
	 * The constructor of class RideManager
	 * @param sortingStrategy The sorting strategy which sorts the drivers
	 * @param rideRequest the ride request of the customer
	 */
	public RideManager(DriversSortingStrategy sortingStrategy,RideRequest rideRequest){
		this.rideRequest=rideRequest;
		this.sortingStrategy=sortingStrategy;
	}
	
	
	
	/**
	 * This method simulates the ride from the point the customer choose the rideType to the end of the ride and the driver becoming on duty again
	 */
	public void run(){
		synchronized(rideRequest){
			while(!rideRequest.completed()){
				if (rideRequest.getRides().size()==2){
					try {
						rideRequest.wait(600000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					break;
				}
				try {
					rideRequest.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			RideFactory.poolList=null;
		}
		assignDriver();
		pickAll();
		rideRequest.setState(RideState.ongoing);
		dropOffAll();
		markAndTerminateRide();
		rideRequest.setState(RideState.completed);
		rideRequest.setDriverState(DriverState.onDuty);
		rideRequest.getDriver().setRideOnGoing(null);
		try {
			join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
	
	
	/**
	 * This method updates the position of the car while picking up each customer of the ride request.  
	 */
	public void pickAll() {
		TrafficState trafficState = rideRequest.getTrafficState();
		double speed = trafficState.getAverageSpeed();
		
		//a list of the minimum distances the driver will have to go through to pick up every customer of the ride request
		ArrayList<Double> trajectoryDistances = new ArrayList<Double>();
		//a sorted list of the rides in the ride request ordered by the pickup strategy 
		ArrayList<Ride> sortedPickUpRides = new ArrayList<Ride>();

		ArrayList<Ride> rides = new ArrayList<Ride>();
		for(Ride r : rideRequest.getRides()) {rides.add(r);}
		
		//initializing the parameter of the while loop
		Position driverPosition = rideRequest.getDriver().getPosition();
		int minInd;
		double distanceMin;
		
		//order the rides to minimize the total distance the driver will go through and fill trajectoryDistances and sortedPickUpRides
		while(rides.size()>0) {
			minInd=0;
			distanceMin=Double.MAX_VALUE;
			for(int i=0;i<rides.size();i++) {
				double distance=driverPosition.calculateLength(rides.get(i).getCustomer().getPosition());
				if (distance<distanceMin) {
					distanceMin=distance;
					minInd=i;	
				}
			}
			trajectoryDistances.add(distanceMin);
			sortedPickUpRides.add(rides.get(minInd));
			driverPosition = rides.get(minInd).getCustomer().getPosition();
			rides.remove(minInd);
		}
	
		//We have the list of the distances and the corresponding ride for each point
		//We now update the car position at the right time
		synchronized(rideRequest) {
			while(sortedPickUpRides.size()>0) {
				double timeToPickUp = trajectoryDistances.get(0)/speed;
				try {
					sleep((long) timeToPickUp);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				sortedPickUpRides.remove(0);
				rideRequest.getDriver().getCarUsed().setPosition(rides.get(0).getStartingPoint());
				
				rides.remove(0);
			}
		}
	}
	
	
	
	/**
	 * This method updates the position of the car while dropping off each customer of the ride request.  

	 */
	public void dropOffAll() {
		TrafficState trafficState = rideRequest.getTrafficState();
		double speed = trafficState.getAverageSpeed();
		
		//a list of the minimum distances the driver will have to go through to pick up every customer of the ride request
		ArrayList<Double> trajectoryDistances = new ArrayList<Double>();
		//a sorted list of the rides in the ride request ordered by the drop off strategy 
		ArrayList<Ride> sortedDropOffRides = new ArrayList<Ride>();

		ArrayList<Ride> rides = new ArrayList<Ride>();
		for(Ride r : rideRequest.getRides()) {rides.add(r);}
		
		Position driverPosition = rideRequest.getDriver().getPosition();
		int minInd=0;
		double distanceMin=Double.MAX_VALUE;
		
		while(rideRequest.getRides().size()>0) {
			minInd=0;
			distanceMin=Double.MAX_VALUE;
			for(int i=0;i<rides.size();i++) {
				double distance=driverPosition.calculateLength(rides.get(i).getDestination());
				if (distance<distanceMin) {
					distanceMin=distance;
					minInd=i;	
				}
			}
			trajectoryDistances.add(distanceMin);
			sortedDropOffRides.add(rides.get(minInd));
			driverPosition = rides.get(minInd).getDestination();
			rides.remove(minInd);
		}
		//We have the list of the distances and the corresponding ride for each point
		//We now update the car position at the right time
		synchronized(rideRequest) {
			while(sortedDropOffRides.size()>0) {
				double timeToPickUp = trajectoryDistances.get(0)/speed;
				try {
					sleep((long) timeToPickUp);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				sortedDropOffRides.remove(0);
				rideRequest.getDriver().getCarUsed().setPosition(rides.get(0).getDestination());
				rides.remove(0);
			}
		}
	}
	
	
	
	/**
	 * This method asks the customer to give a mark to the driver for this ride and finally updates the driver state, the ride state
	 */
	public void markAndTerminateRide() {
		ArrayList<Ride> allRides=rideRequest.getRides();
		for(Ride ride:allRides) {
			/*ride.customer.addMessage("You ride has been completed. We hope you enjoyed it. Would you please mark your driver.");
			*/
			if(ride.getMark()==-1) {
				int mark=ride.getCustomer().askForAMark();
				ride.setMark(mark);
			}
			ride.getCustomer().charge(ride.getPrice());
			ride.getCustomer().setNbOfRides(ride.getCustomer().getNbOfRides()+1);
			ride.getDriver().cash(ride.getPrice());
			//ride.getCustomer().addTimeSpentOnARide(ride.getDepositeTime().getTimeInMillis()-ride.getPickingTime().getTimeInMillis());
			BookOfRides.add(ride);
			ride.getCustomer().setRideOnGoing(null);
		}
	}
	
	
	/**
	 * This method assigns a driver to the ride request
	 */
	public synchronized void assignDriver(){
		ArrayList<Driver> classement = sortingStrategy.sortDrivers(rideRequest);
		while (rideRequest.getDriver()==null) {
			for (Driver driver : classement) {
				synchronized(driver.lockOnRequest){
					driver.forwardARequest(rideRequest);
					if (rideRequest.getState()==RideState.confirmed) {
						rideRequest.setDriver(driver);
						break;
					}	
				}
			}
		}
	}

	
}
