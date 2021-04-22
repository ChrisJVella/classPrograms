
/***
 * Class to model a Date implementing the Comparable interface
 * @author Christopher Vella
 * @version 0.1
 * Date of Creation: February 22, 2021
 * Last Date Modified: March 11, 2021
 */
public class Date 
		implements Comparable<Date>{
	//Data members
	private int month;
	private int day;
	private int year;
	
	/**
	 * Default constructor
	 * Initializes month, day, and year to the int 0
	 */
	public Date() {
		month = 0;
		day = 0;
		year = 0;
	}
	/**
	 * Constructor with three parameters
	 * @param month to set the month of a Date
	 * @param day to set the day of a Date
	 * @param year to set the year of a Date
	 */
	public Date(int month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
	}
	
	/**
	 * Getter for the month of a Date
	 * @param no parameters
	 * @return the value of the data member month
	 */
	public int getMonth() {
		return month;
	}
	/**
	 * Getter for the day of a Date
	 * @param no parameters
	 * @return the value of the data member day
	 */
	public int getDay() {
		return day;
	}
	/**
	 * Getter for the year of a Date
	 * @param no parameters
	 * @return the value of the data member year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * Setter for the month of a Date
	 * @param month to set the month of a Date
	 * @return no return value
	 */
	public void setMonth(int month) {
		this.month = month;
	}
	/**
	 * Setter for the day of a Date
	 * @param day to set the day of a Date
	 * @return no return value
	 */
	public void setDay(int day) {
		this.day = day;
	}
	/**
	 * Setter for the year of a Date
	 * @param year to set the year of a Date
	 * @return no return value
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * Method to get the information of a Date
	 * @param no parameters
	 * @return formatted string containing the value of the data members
	 */
	public String toString() {
		return String.format("%02d/%02d/%4d", month, day, year);
	}
	/**
	 * Used by the Comparable interface to order a Date based on its year, month, and day.
	 * @param a Date to compare to
	 * @return an int depending on the order of the Date
	 */
	public int compareTo(Date d) {
		if(getYear() < d.getYear())
			return 1;
		else if(getYear() > d.getYear())
			return -1;
		else {
			if(getMonth() < d.getMonth())
				return 1;
			else if(getMonth() > d.getMonth())
				return -1;
			else {
				if(getDay() < d.getDay())
					return 1;
				else if(getDay() > d.getDay())
					return -1;
				else
					return 0;
			}
		}
	}

}
