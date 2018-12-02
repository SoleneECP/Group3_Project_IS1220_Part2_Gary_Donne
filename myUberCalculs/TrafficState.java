package myUberCalculs;
import java.util.Calendar;
import java.util.Random;

public enum TrafficState {
	
	/**
	 * names of the 3 different traffic state
	 */
	lowTraffic(15), 
	mediumTraffic(7.5), 
	heavyTraffic(3);
	
	/**
	 * the average speed of a ride
	 */
	
	private double averageSpeed;
	
	/**
	 * creates a traffic state with a given initial average speed
	 * @param averageSpeed
	 */
	
	TrafficState(double averageSpeed){
		this.averageSpeed=averageSpeed;
	}
	
	/**
	 * get the average speed of a ride according to the traffic state 
	 * @return the average speed of a ride
	 */
	
	public double getAverageSpeed() {
		return averageSpeed;
	}
	
	/**
	 * get the traffic state of a ride
	 * @param calendar hour of the customer's ride request
	 * @return the traffic state of a ride
	 */
	
	public static TrafficState getTrafficState(Calendar calendar) {
		double r = Math.random();
		int date=calendar.get(Calendar.HOUR_OF_DAY);
		if (22<=date || date<7) {
			if (r<0.95) {return TrafficState.lowTraffic;}
			else if (0.95<=r && r<0.99) {return TrafficState.mediumTraffic;}
			else {return TrafficState.heavyTraffic;}
		}
		else if (7<=date && date>11) {
			if (r<0.05) {return TrafficState.lowTraffic;}
			else if (0.05<=r && r<0.25) {return TrafficState.mediumTraffic;}
			else {return TrafficState.heavyTraffic;}
		}		
		else if(11<=date && date<17) {
			if (r<0.15) {return TrafficState.lowTraffic;}
			else if (0.15<=r && r<0.85) {return TrafficState.mediumTraffic;}
			else {return TrafficState.heavyTraffic;}
		}
		else {if (r<0.01) {return TrafficState.lowTraffic;}
		else if (0.01<=r && r<0.05) {return TrafficState.mediumTraffic;}
		else {return TrafficState.heavyTraffic;}
			
		}
	}
}
