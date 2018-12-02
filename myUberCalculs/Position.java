package myUberCalculs;

import java.util.*;

/**
 * 
 *
 * The position of a MyUber user
 */

public class Position {
	
	/**
	 * longitude of the user's position
	 */
	private double x;
	/**
	 * latitude of the user's position
	 */
	private double y;
	
	/**
	 * creates a position with given initial longitude and latitude
	 * @param x the initial longitude of the user's position
	 * @param y the initial latitude of the user's position
	 */
	
	public Position(double x, double y) {
		this.x=x;
		this.y=y;
	}
	
	/**
	 * get the longitude of the user's position 
	 * @return the longitude of the user's position
	 */
	
	public double getX() {
		return x;
	}
	
	/**
	 * get the latitude of the user's position 
	 * @return the latitude of the user's position
	 */

	public double getY() {
		return y;
	}
	
	/**
	 * set the longitude of the user's position to a certain value
	 * @param x the longitude the user's position is going to be set to
	 */

	public void setX(double x) {
		this.x = x;
	}
	
	/**
	 * set the latitude of the user's position to a certain value
	 * @param y the latitude the user's position is going to be set to
	 */

	public void setY(double y) {
		this.y = y;
	}
	
	/**
	 * testing if @param obj is equaled to position
	 */

	public boolean equals(Object obj) {
		if(obj instanceof Position) {
			Position p = (Position)obj;
			return (p.getX()==this.x)&&(p.getY()==this.y);
		}
		return false;
	}
	
	/**
	 * Calculate of the distance between two positions 
	 * @param p a position
	 * @return the distance between position p1 and position p2
	 */
	
	public double calculateLength(Position p) {
		double length = Math.sqrt(Math.pow((this.getX()-p.getX()),2) + Math.pow((this.getY()-p.getY()),2));
		return length;
	}

}
