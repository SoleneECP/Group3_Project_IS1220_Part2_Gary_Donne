package myUberUsers;
import java.util.ArrayList;

import myUberRidesOperations.RideRequest;

public interface DriversSortingStrategy {
	
	default public ArrayList<Driver>  sortDrivers(RideRequest rideRequest){
		return null;
	}
	
	default public ArrayList<Driver> sortDrivers(){
		return null;
	}

}
