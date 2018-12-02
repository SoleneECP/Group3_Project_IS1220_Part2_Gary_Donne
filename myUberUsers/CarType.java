package myUberUsers;

public enum CarType {
	
	Standard(4),
	Berline(4),
	Van(6);
	
	
	/**
	 * the maximum number of customers a type of car can bring
	 */
	private int capacity;
	
	/**
	 * Constructor of the enum class CarType
	 * @param capacity the maximum number of customers a type of car can bring
	 */
	CarType(int capacity){
		this.capacity=capacity;
	}
	
	/**
	 * get the maximum number of customers a type of car can bring 
	 * @return the maximum number of customers a type of car can bring
	 */
	
	public int getCarCapacity() {
		return capacity;
	}
	

}
