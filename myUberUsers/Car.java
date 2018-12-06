package myUberUsers;

import java.util.ArrayList;

import myUberCalculs.Position;

public class Car {
	
	/**
	 * The car current position
	 */
	private Position position;
	
	/**
	 * the carType of the car
	 */
	private CarType carType;
	/**
	 * The car unique ID
	 */
	private String id;
	
	/**
	 * List of the drivers using that car
	 */
	private ArrayList<Driver> drivers;
	
	/**
	 * The constructor of class Car
	 * @param carType the Type of car of the car 
	 * @param position the current position of the car
	 */
	public Car (CarType carType) {
		this.carType = carType;
		this.position = position;
		IdGenerator idgencar = IdGenerator.getInstance();
		id = idgencar.getNextCarId(carType);
		double r=Math.random();
		int x=(int) (-50+r*100);
		r=Math.random();
		int y=(int) (-50+r*100);
		this.position = new Position(x,y);
		ArrayList<Driver> drivers = new ArrayList<Driver>();
	}
	
	/**
	 * Add a new driver to this car
	 * @param driver the new driver added 
	 */
	public void addDriver(Driver driver) {
		this.drivers.add(driver);
	}
	
	/**
	 * get the current position of the car
	 * @return the current position of the car
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * get the CaType of a car
	 * @return the CaType of a car
	 */
	public CarType getCarType() {
		return carType;
	}

	/**
	 * get the unique ID of a car
	 * @return the unique ID of a car
	 */
	public String getId() {
		return id;
	}

	/**
	 * set a new current position to the car
	 * @param newposition the new Position of the car we want to set the car to
	 * @return the new Position of the car
	 */
	public Position setPosition(Position newposition) {
		this.position = newposition;
		return position;
	}

	public ArrayList<Driver> getDrivers() {
		return drivers;
	}

	public void setDrivers(ArrayList<Driver> drivers) {
		this.drivers = drivers;
	}

	public void setCarType(CarType carType) {
		this.carType = carType;
	}

	@Override
	public String toString() {
		return "Car [position=" + position + ", carType=" + carType + ", id=" + id + ", drivers using it=" + drivers + "]";
	}
	
}
