package myUberRidesOperations;
import java.util.ArrayList;

import myUberCalculs.TrafficState;
import myUberUsers.Driver;
import myUberUsers.DriverState;

public class PoolRequest implements RideRequest{
	
	ArrayList<Ride> pool;
	RideType rideType=RideType.UberPool;
	RideState rideState;
	
	public PoolRequest(Ride ride){
		pool=new ArrayList<Ride>();
		pool.add(ride);
	}
	
	@Override
	public void setState(RideState rideState){
		this.rideState=rideState;
		for (Ride r: pool){
			r.setState(rideState);
		}
	}
	
	@Override 
	public void setDriverState(DriverState driverState) {
		for(Ride r:pool) {
			r.getDriver().setDriverState(driverState);
		}
	}
	
	
	public void add(Ride ride) {
		pool.add(ride);
	}

	@Override
	public ArrayList<Ride> getRides() {
		return pool;
	}

	@Override
	public boolean completed() {
		return pool.size()==3;
	}
	
	@Override
	public RideType getRideType() {
		return this.rideType;
	}
	
	@Override 
	public TrafficState getTrafficState() {
		return pool.get(pool.size()-1).getTrafficState();
	}

	@Override
	public RideState getState() {
		return this.rideState;
	}

	@Override
	public void setDriver(Driver driver) {
		 for(Ride ride : pool) {
			 ride.setDriver(driver);
		 }
	}

	@Override
	public Driver getDriver() {
		return pool.get(0).getDriver();
	}
	
	
	

}
