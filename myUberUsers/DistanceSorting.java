package myUberUsers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map.Entry;

import myUberCalculs.Position;
import myUberRidesOperations.Ride;
import myUberRidesOperations.RideRequest;

import java.util.TreeMap;

public class DistanceSorting implements DriversSortingStrategy {

	/**
	 * sort the available drivers according to the pick-up/drop-off strategy, this sorted list is then used to assign a driver to a ride request
	 */
	@Override
	public ArrayList<Driver>  sortDrivers(RideRequest rideRequest) {
		ArrayList<Driver> sortedDrivers = new ArrayList<Driver>();
		ArrayList<Double> trajectoryCosts = new ArrayList<Double>();
		ArrayList<Driver> drivers = new ArrayList<Driver>();

		for(Driver d : MyUberPopulation.getAvailableDrivers()) {drivers.add(d);}

		
		for(Driver d : drivers) {
			trajectoryCosts.add(trajectorycost(d, rideRequest));
		}
		while(trajectoryCosts.size()>0) {
			int a = getMinIndice(trajectoryCosts);
			sortedDrivers.add(drivers.get(a));
			trajectoryCosts.remove(a);
		}
		
		return sortedDrivers;
		
	}
	
	
	/**
	 * Calculate the cost of the trajectory according to the pick-up/drop-off strategy for a driver on-Duty
	 * @param driver the driver for whom the cost is calculated
	 * @param rideRequest the rideRequest the cost is calculated for
	 * @return the "cost" of the trajectory which means the distance between points (=customers starting positions) in the sequence plus the distance of the car from the first point n the sequence.
	 */
	public double trajectorycost(Driver driver, RideRequest rideRequest) {
		double trajectorycost = 0;
		ArrayList<Position> startingpositions = new ArrayList<Position>();
		ArrayList<Position> destinations = new ArrayList<Position>();

		for (Ride r :  rideRequest.getRides()) {
			startingpositions.add(r.getCustomer().getPosition());
			destinations.add(r.getDestination());}
		
		Position driverPosition = driver.getPosition();
		int minInd=0;
		double distanceMin=Double.MAX_VALUE;
		while(startingpositions.size()>=1) {
			minInd=0;
			distanceMin=Double.MAX_VALUE;
			for(int i=0;i<startingpositions.size();i++) {
				System.out.println(startingpositions.size()+"ahah"+i);
				double distance=driverPosition.calculateLength(startingpositions.get(i));
				if (distance<distanceMin) {
					distanceMin=distance;
					minInd=i;	
				}		
			}
			trajectorycost+=distanceMin;
			driverPosition = startingpositions.get(minInd);
			startingpositions.remove(minInd);
		}
		
		minInd=0;
		distanceMin=Double.MAX_VALUE;
		while(destinations.size()>=1) {
			minInd=0;
			distanceMin=Double.MAX_VALUE;
			for(int i=0;i<destinations.size();i++) {
				System.out.println(destinations.size()+"ahah"+i);
				double distance=driverPosition.calculateLength(destinations.get(i));
				if (distance<distanceMin) {
					distanceMin=distance;
					minInd=i;	
				}		
			}
			trajectorycost+=distanceMin;
			driverPosition = destinations.get(minInd);
			destinations.remove(minInd);
		}
		
		return trajectorycost;

	}
	
	
	/**
	 * get the index of the minimum number in an ArrayList
	 * @param distances the ArrayList in which the index of the minimum is searched
	 * @return the index of the minimum number in an ArrayList
	 */
	public int getMinIndice ( ArrayList<Double> distances) {
		double min = distances.get(0);
		int minIndice = 0;
		for(int i=1; i<distances.size();i++) {
			if(distances.get(i)<min) {
				min=distances.get(i);
				minIndice =i;
			}
		}
		return minIndice;
	}

}
