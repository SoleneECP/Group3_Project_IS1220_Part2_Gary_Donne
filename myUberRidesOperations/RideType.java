package myUberRidesOperations;

import myUberUsers.CarType;

public enum RideType {
	
	UberX(CarType.Standard),
	UberPool(CarType.Standard),
	UberBlack(CarType.Berline),
	UberVan(CarType.Van);
	
	private CarType carType;
	
	RideType (CarType carType){
		this.carType=carType;
	}
	
	public CarType getCompatibleCarType() {
		return carType;
	}
	
	

}
