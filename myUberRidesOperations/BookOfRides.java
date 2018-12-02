package myUberRidesOperations;

import java.util.ArrayList;
import java.util.*;

/**
 * 
 * Class which remembers all the rides that has been completed
 *
 */
public class BookOfRides {
	/**
	 * the array representing the bookOfRides, with the historic of all completed rides, static attribute
	 */
	private static ArrayList<Ride> bookOfRides=new ArrayList<Ride>();
	
	/**
	 * Set the bookOfRides to the array put in parameter
	 * @param rides the new value of BookOfRides
	 */
	public static void setBookOfRides(ArrayList<Ride> rides) {
		BookOfRides.bookOfRides=rides;
	}
	
	/**
	 * Add a completed ride to the BookOfRides
	 * @param ride A ride whose state is completed
	 */
	public static synchronized void add(Ride ride) {
		BookOfRides.bookOfRides.add(ride);
	}
	/**
	 * Get all the historic of the rides in the book of rides
	 * @return all the historic of the rides in the book of rides
	 */
	public static synchronized ArrayList<Ride> getBookOfRides(){
		return bookOfRides;
	}

}
