
/***
 * Class to model a Time implementing the Comparable interface
 * @author Christopher Vella
 * @version 0.1
 * Date of Creation: February 22, 2021
 * Last Date Modified: March 11, 2021
 */
public class Time 
		implements Comparable<Time>{
	//Data members
	private int hours;
	private int minutes;
	
	/**
	 * Default constructor
	 * Initializes hours and minutes to the int 0
	 */
	public Time() {
		hours = 0;
		minutes = 0;
	}
	/**
	 * Constructor with two parameters
	 * @param hours to set the hours of a Time
	 * @param minutes to set the minutes of a Time
	 */
	public Time(int hours, int minutes) {
		this.hours = hours;
		this.minutes = minutes;
	}
	
	/**
	 * Getter for the hours of a Time
	 * @param no parameters
	 * @return the value of the data member hours
	 */
	public int getHours() {
		return hours;
	}
	/**
	 * Getter for the minutes of a Time
	 * @param no parameters
	 * @return the value of the data member minutes
	 */
	public int getMinutes() {
		return minutes;
	}
	/**
	 * Setter for the hours of a Time
	 * @param hours to set the hours of a Time
	 * @return no return value
	 */
	public void setHours(int hours) {
		this.hours = hours;
	}
	/**
	 * Setter for the minutes of a Time
	 * @param minutes to set the minutes of a Time
	 * @return no return value
	 */
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	/**
	 * Method to get the information of a Time
	 * @param no parameters
	 * @return formatted string containing the value of the data members
	 */
	public String toString() {
		return String.format("%02d:%02d", hours, minutes);
	}
	/**
	 * Used by the Comparable interface to order a Time based on its hours and minutes.
	 * @param a Time to compare to
	 * @return an int depending on the order of the Time
	 */
	public int compareTo(Time t) {
		if(getHours() < t.getHours())
			return 1;
		else if(getHours() > t.getHours())
			return -1;
		else {
			if(getMinutes() < t.getMinutes())
				return 1;
			else if(getMinutes() > t.getMinutes())
				return -1;
			else
				return 0;
		}
	}

}
