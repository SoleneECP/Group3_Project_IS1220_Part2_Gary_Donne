package myUberUsers;
import java.util.Calendar;
import java.util.EnumMap;
import java.util.Map;

import myUberCalculs.Position;
import myUberRidesOperations.RideRequest;
import myUberRidesOperations.RideState;

/**
 * The class representing a Driver
 *
 */

public class Driver implements Visitable {
	
	/**
	 * The driver's name
	 */
	private String name;
	/**
	 * The surname's name
	 */
	private String surname;
	/**
	 * The driver's unique ID
	 */
	private int id;
	/**
	 * The car used by the driver
	 */
	private Car carUsed;
	/**
	 * The driver current state
	 */
	private DriverState driverState;
	/**	
	 * A map with th Key Performance Indicators : representing the time spent in each driver state
	 */
	private EnumMap<DriverState, Long> tableKPI;
	/**
	 * the time when the driver last changes its state
	 */
	private Calendar lastStateChange;

	/**
	 * The amount of money the driver earned thanks to  the ride he has accomplished
	 */
	private double amountOfCash;
	
	
	/**
	*a reference to the ride the Driver is doing currently. null if driver not on a ride
	*/
	RideRequest rideOnGoing=null;
	
	/**
	*a lock allowing only one thread to submit a request at a time
	*The thread hold on to the lock till the driver has either accepted or declined the ride request
	*/
	public Object lockOnRequest = new Object();
	
	/**
	 * The key of the map is the mark (1 to 5); the value is the number of time the driver was given this mark
	 */
	private Map<Integer, Integer> marks;
	
	
	/**
	 * The driver constructor 
	 * @param name the driver's name
	 * @param surname the driver's surname
	 * @param carUsed the car currently used by the driver
	 * @param driverState the driver current state
	 */
	public Driver (String name, String surname) {
		this.name=name;
		this.surname=surname;
		this.driverState=DriverState.offline;
		IdGenerator idgendriv = IdGenerator.getInstance();
		this.id = idgendriv.getNextDriverId();
	}
	
	public Driver(String name, String surname, Car car) {
		this.name = name;
		this.surname=surname;
		this.carUsed=car;
	}
	
	
	/**
	 * the driver accepts or not the rideRequest 
	 * @param rideRequest the ride request of the customer 
	 */
	public void forwardARequest(RideRequest rideRequest) {
			if (this.driverState==DriverState.onDuty){
				synchronized(rideRequest){
					if(this.carUsed.getCarType()==rideRequest.getRideType().getCompatibleCarType()){
						double random=Math.random();
						if (random<0.8)  {
							acceptARide(rideRequest);
						}
					}
				}	
			}
	}
	
	/**
	 * change the driver currently state to a new state and register and update the value of the tableKPI
	 * @param newstatus the driver state is set to
	 */
	public void setDriverState (DriverState newstatus) {
		Calendar newLastStateChange = Calendar.getInstance();
		this.tableKPI.put(this.driverState, tableKPI.get(this.driverState)+
				(newLastStateChange.getTimeInMillis()-this.lastStateChange.getTimeInMillis()));
		this.driverState=newstatus;
		this.lastStateChange=newLastStateChange;
	}
	
	
	/**
	 * the driver has accepted a ride and as a consequence update its state and the ride state
	 * @param rideRequest the rideRequest the driver accepted
	 */
	private void acceptARide(RideRequest rideRequest){
		rideRequest.setState(RideState.confirmed);
		this.setDriverState(DriverState.onARide);
		rideOnGoing=rideRequest;
	}
	
	public Position getPosition(){
		return this.carUsed.getPosition();
		}


	public String getDriverName() {
		return name;
	}


	public void setDriverName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public Car getCarUsed() {
		return carUsed;
	}


	public void setCarUsed(Car carUsed) {
		this.carUsed = carUsed;
	}


	public DriverState getStatus() {
		return driverState;
	}


	public void setStatus(DriverState driverState) {
		this.driverState = driverState;
	}


	public int getDriverId() {
		return id;
	}

	/**
	 * update the amountOfCash when the customer is dropped off and pays the driver
	 * @param price the price of the ride
	 */
	public void cash(double price) {
		this.amountOfCash += price;
	}
	
	public double getAmountOfCash() {
		return this.amountOfCash;
	}

	public RideRequest getRideOnGoing() {
		return rideOnGoing;
	}

	public void setRideOnGoing(RideRequest rideOnGoing) {
		this.rideOnGoing = rideOnGoing;
	}

	@Override
	public void accept(DriversOperationVisitor operation) {
		
		
	}
	
	
}

