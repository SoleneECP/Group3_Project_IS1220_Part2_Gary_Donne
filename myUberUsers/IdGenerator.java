package myUberUsers;
import java.util.EnumMap;

/**
 * This class is a Singleton Pattern, it generates unique Id for cars, customers and drivers
 */

public class IdGenerator {
	
	private static IdGenerator instance = null;
	
	/**
	 * The numerical id of a car (but not its final id)
	 */
	private int carIdNum;
	/**
	 * The customer numerical Id
	 */
	private int customerId;
	/**
	 * The driver numerical Id
	 */
	private int driverId;
	
	
	/**
	 * The default constructor of IdGenerator, set to private
	 */
	private IdGenerator() {}
	
	/**
	 * Constructor of Singleton Pattern IdGenerator 
	 * @return return the unique instance of IdGenerator 
	 */
	public static IdGenerator getInstance() {
		if (instance==null) {
			instance = new IdGenerator();
		}
		return instance;
	}
	
	/**
	 * give a unique ID for a new car
	 * @param carType the carType of the car which needs a unique Id
	 * @return a unique car ID
	 */
	public synchronized String getNextCarId(CarType carType) {
		this.carIdNum=carIdNum+1;
		System.out.println(carType.toString() + carIdNum);
		return carType.toString() + carIdNum;
	}
	
	/**
	 * give a unique ID for a new customer
	 * @return a unique customer ID
	 */
	public synchronized int getNextCustomerId() {
		this.customerId=customerId+1;
		return customerId;
	}
	
	/**
	 * give a unique ID for a new driver
	 * @return a unique driver ID
	 */
	public synchronized int getNextDriverId() {
		this.driverId=driverId+1;
		return driverId;
	}
	
	/**
	 * Represent the different current IDs for an instance of IdGenerator in String
	 */
	@Override
	public String toString() {
		return "The current Id for cars is"+ carIdNum +
				",The current Id for customers is"+ customerId +
				",The current Id for Drivers is"+ driverId;
	}

}
