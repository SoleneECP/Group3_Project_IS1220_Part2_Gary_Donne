package myUberRidesOperations;
import java.util.ArrayList;

import myUberCalculs.TrafficState;
import myUberUsers.Driver;
import myUberUsers.DriverState;

public interface RideRequest {
	
	public ArrayList<Ride> getRides();
	public boolean completed();
	public RideType getRideType();
	public RideState getState();
	public void setDriver(Driver driver);
	public Driver getDriver();
	default void add(Ride ride) {}
	public void setState(RideState rideState);
	public void setDriverState(DriverState driverState);
	public TrafficState getTrafficState();
}
