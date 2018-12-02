package myUberRidesOperations;
import java.util.ArrayList;
import java.util.Calendar;

import myUberCalculs.Position;
import myUberCalculs.TrafficState;
import myUberUsers.Car;
import myUberUsers.Customer;
import myUberUsers.Driver;
import myUberUsers.DriverState;

public class Ride implements RideRequest {
	
	
	/**
	 * The starting position of the ride
	 */
	private Position startingPoint;
	/**
	 * The destination position of the ride
	 */
	private Position destination;
	/**
	 * The traffic state at booking used to calculate the prices and the average speed of the ride
	 */
	private TrafficState trafficStateAtBooking;
	/**
	 * The customer which asked for this ride
	 */
	private Customer customer;
	/**
	 * The driver assigned for this ride
	 */
	private Driver driver;
	/**
	 * The car used by the driver of the ride
	 */
	private Car carUsed;
	/**
	 * The ride state of this ride
	 */
	private RideState rideState;
	/**
	 * The ride type of this ride
	 */
	private RideType rideType;
	/**
	 * The booking time is the time when the customer makes a ride request
	 */
	private Calendar bookingTime;
	/**
	 * The picking time is the time when the driver picked up the customer
	 */
	private Calendar pickingTime;
	/**
	 * The deposite time is the time when the driver drop off the customer
	 */
	private Calendar depositeTime;
	/**
	 * The price of the ride
	 */
	private double price;
	/**
	 * The mark given by the customer of the ride when the ride is completed, have a default value before
	 */
	private int mark;
	
	
	
	/**
	 * The constructor of the ride class
	 * @param destination the destination position of the ride
	 * @param customer the customer of the ride
	 */
	public Ride (Position destination, Customer customer) {
		this.destination=destination;
		this.customer=customer;
		this.mark=-1;
	}
	
	
	@Override
	public void setState(RideState rideState) {
		this.rideState = rideState;
	}
	
	@Override
	public void setDriverState(DriverState driverState) {
		this.driver.setDriverState(driverState);
	}
	

	@Override
	public ArrayList<Ride> getRides() {
		ArrayList<Ride> temp=new ArrayList<Ride>();
		temp.add(this);
		return temp;		
	}

	@Override
	public boolean completed() {
		return true;
	}

	
	public RideType getRideType() {
		return this.rideType;
	}
	
	public void setRideType(RideType rideType) {
		this.rideType=rideType;
	}
	
	
	public Position getStartingPoint() {
		return startingPoint;
	}

	public void setStartingPoint(Position startingPoint) {
		this.startingPoint = startingPoint;
	}

	public Position getDestination() {
		return destination;
	}

	public void setDestination(Position destination) {
		this.destination = destination;
	}

	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Car getCarUsed() {
		return carUsed;
	}

	public void setCarUsed(Car carUsed) {
		this.carUsed = carUsed;
	}


	@Override
	public TrafficState getTrafficState() {
		return trafficStateAtBooking;
	}
	
	public void setTrafficState(TrafficState trafficState) {
		this.trafficStateAtBooking=trafficState;
	}
	
	public void setBookingTime(Calendar bookingTime) {
		this.bookingTime=bookingTime;
	}

	@Override
	public RideState getState() {
		return this.rideState;
	}
	
	public int getMark() {
		return this.mark;
	}
	
	public void setMark(int mark) {
		this.mark=mark;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public void setPrice(double price) {
		this.price=price;
	}


	public Calendar getPickingTime() {
		return pickingTime;
	}


	public void setPickingTime(Calendar pickingTime) {
		this.pickingTime = pickingTime;
	}


	public Calendar getDepositeTime() {
		return depositeTime;
	}


	public void setDepositeTime(Calendar depositeTime) {
		this.depositeTime = depositeTime;
	}
	
	

}
