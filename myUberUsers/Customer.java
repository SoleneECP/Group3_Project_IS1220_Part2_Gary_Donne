package myUberUsers;
import java.sql.Driver;
import java.util.Calendar;
import java.util.EnumMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import myUberCalculs.Position;
import myUberCalculs.Prices;
import myUberRidesOperations.Ride;
import myUberRidesOperations.RideFactory;
import myUberRidesOperations.RideType;

public class Customer{
	
	/**
	 * The name of the customer
	 */
	private String name;
	
	/**
	 * The surname of the customer
	 */
	private String surname;
	
	/**
	 * The customer's current position
	 */
	private Position position;
	
	/**
	 * The unique customer's credit card number
	 */
	private double creditCardNb;
	
	/**
	 * Customer's total number of Uber rides 
	 */
	private int nbOfRides;
	
	/**
	 * Total amount of money spent by a customer in Uber rides
	 */
	private double amountOfCharges;
	
	/**
	 * Total amount of time spent by a customer in Uber rides
	 */
	private double amountOfTime;
	
	
	private Ride rideOnGoing;
	
	/**
	 * The unique ID of the customer
	 */
	private int id;

	
	/**
	 * The customer constructor
	 * @param startingpos the current position of the customer when asking for a ride
	 */
	public Customer(Position startingpos) {
		this.position=startingpos;
		IdGenerator idgencust = IdGenerator.getInstance();
		this.id = idgencust.getNextCustomerId();
	}
	
	public Customer (String name, String surname) {
		this.name = name;
		this.surname = surname;
		IdGenerator idgencust = IdGenerator.getInstance();
		this.id = idgencust.getNextCustomerId();
		double r=Math.random();
		int x=(int) (-50+r*100);
		r=Math.random();
		int y=(int) (-50+r*100);
		this.position = new Position(x,y);
	}
	
	
	/**
	 * The customer makes a ride request for a given destination and a ride process is launched
	 * @param destination the destination of the ride request
	 */
	public void getARide(Position destination){
		synchronized(rideOnGoing) {
			if(rideOnGoing==null) {
				RideFactory.createARide(this,destination);
				}
			else {
				System.out.println("This Customer is already or has already asked for a ride");
			}
		}
	}
	
	
	
	public void getARide(Position destination, RideType rideType, double mark){
		
	}
	
	
	/**
	 * get the customer's initial position
	 * @return the customer's initial position
	 */

	public Position getPosition() {
		return position;
	}
	
	/**
	 * set the customer's initial position to a certain value
	 * @param startingpos the customer's initial position is going to be set to
	 */

	public void setPosition(Position startingpos) {
		this.position = startingpos;
	}
	
	/**
	 * get the customer's unique credit card number
	 * @return the customer's unique credit card number
	 */

	public double getCreditCardNb() {
		return creditCardNb;
	}
	
	/**
	 * set the customer's unique credit card number to a certain value
	 * @param creditCardNb the customer's unique credit card number is going to be set to
	 */

	public void setCreditCardNb(double creditCardNb) {
		this.creditCardNb = creditCardNb;
	}
	
	/**
	 * get the customer's total number of Uber rides
	 * @return the customer's total number of Uber rides
	 */

	public int getNbOfRides() {
		return nbOfRides;
	}
	
	/**
	 * set the customer's total number of Uber rides to a certain value
	 * @param nbOfRides the customer's total number of Uber rides is going to be set to
	 */

	public void setNbOfRides(int nbOfRides) {
		this.nbOfRides = nbOfRides;
	}
	
	/**
	 * get the customer's total amount of charges payed to Uber drivers
	 * @return the customer's total amount of charges payed to Uber drivers
	 */

	public double getAmountOfCharges() {
		return amountOfCharges;
	}
	
	/**
	 * set the customer's total amount of charges payed to Uber drivers to a certain value
	 * @param amountOfCharges the customer's total amount of charges payed to Uber drivers is going to be set to
	 */

	public void setAmountOfCharges(double amountOfCharges) {
		this.amountOfCharges = amountOfCharges;
	}
	
	/**
	 * get the customer's total amount of time spent in Uber rides
	 * @return the customer's total amount of time spent in Uber rides
	 */

	public double getAmountOfTime() {
		return amountOfTime;
	}
	
	/**
	 * set the customer's total amount of time spent in Uber rides to a certain value
	 * @param amountOfTime the customer's total amount of time spent in Uber rides is going to be set to
	 */

	public void setAmountOfTime(double amountOfTime) {
		this.amountOfTime = amountOfTime;
	}

	/**
	 * ask for the customer to give a mark to the ride : without the user interface, the mark is given randomly
	 * @return the mark of the ride
	 */
	public int askForAMark() {
		Random r = new Random();
		return (r.nextInt((5 - 1) + 1) + 1);
	}

	/**
	 * The customer chooses a ride type according to the different prices : without the user interface, the choice is given randomly (not open-close...)
	 * @param prices the map of the prices according to the ride type 
	 * @return the type of ride he wants
	 */
	public RideType choose(Prices prices) {
		double r = Math.random();
		if(r<0.25) {return RideType.UberBlack;}
		else if(0.25<=r && 0.5<r) {return RideType.UberPool;}
		else if (0.5<=r && r<0.75) {return RideType.UberVan;}
		else {return RideType.UberX;}
	}

	/**
	 * the customer pays for the ride and the total amount of charges is updating
	 * @param price the updated amount of charges in MyUber rides of the customer
	 */
	public void charge(double price) {
		this.amountOfCharges+=price;
	}

	public Ride getRideOnGoing() {
		return rideOnGoing;
	}

	public void setRideOnGoing(Ride rideOnGoing) {
		this.rideOnGoing = rideOnGoing;
	}
	
	
	
}

