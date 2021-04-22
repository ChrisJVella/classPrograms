
/**
 * Abstract class to model an Event implementing the Comparable interface
 * @author Christopher Vella
 * @version 0.1
 * Date of Creation: February 22, 2021
 * Last Date Modified: March 11, 2021
 */
public abstract class Event 
		implements Comparable<Event>{
	//Data members
	private String description;
	private Date date;
	private Time time;
	private String location;
	
	/**
	 * Default constructor
	 * Initializes description and location to the string "none", date to a default date, and time to a default time
	 */
	public Event() {
		description = "none";
		date = new Date();
		time = new Time();
		location = "none";
	}
	/**
	 * Constructor with four parameters
	 * @param description for the description of an Event
	 * @param date for the date of an Event
	 * @param time for the time of an Event
	 * @param location for the location of an Event
	 */
	public Event(String description, Date date, Time time, String location) {
		this.description = description;
		this.date = date;
		this.time = time;
		this.location = location;
	}
	
	/**
	 * Getter for the description of an Event
	 * @param no parameters
	 * @return the value of the data member description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * Getter for the date of an Event
	 * @param no parameters
	 * @return the value of the Date date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * Getter for the time of an Event
	 * @param no parameters
	 * @return the value of the Time time
	 */
	public Time getTime() {
		return time;
	}
	/**
	 * Getter for the location of an Event
	 * @param no parameters
	 * @return the value of the data member location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * Setter for the description of an Event
	 * @param description to set the description of an Event
	 * @return no return value
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * Setter for the date of an Event
	 * @param month to set the month of a Date
	 * @param day to set the day of a Date
	 * @param year to set year of a Date
	 * @return no return value
	 */
	public void setDate(int month, int day, int year) {
		date = new Date(month, day, year);
	}
	/**
	 * Setter for the time of an Event
	 * @param hours to set the hours of the Time
	 * @param minutes to set the minutes of the Time
	 * @Return no return value
	 */
	public void setTime(int hours, int minutes) {
		time = new Time(hours, minutes);
	}
	/**
	 * Setter for the location of an Event
	 * @param location to set the location of an Event
	 * @return no return value
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * Method to get the information of an Event
	 * @param no parameters
	 * @return formatted string containing the value of the data members
	 */
	public String toString() {
		return String.format("%-16s%-8s%-24s%-24s", getDate(), getTime(), getLocation(), getDescription());
	}
	/**
	 * Method to check if the description of one Event is equal to the description of another Event
	 * @param Event a the first Event to compare
	 * @param Event b the second Event to compare
	 * @return true if the descriptions are the same and false if they are not
	 */
	public boolean equals(Event a, Event b) {
		if(a.getDescription().equals(b.getDescription()))
				return true;
		else
			return false;
	}
	/**
	 * Used by the Comparable interface to order an Event based on its Date and Time.
	 * @param an Event to compare to
	 * @return an int depending on the order of the Event
	 */
	public int compareTo(Event e) {
		if(getDate().compareTo(e.getDate())<0)
			return 1;
		else if(getDate().compareTo(e.getDate())>0)
			return -1;
		else {
			if(getTime().compareTo(e.getTime())<0)
				return 1;
			else if(getTime().compareTo(e.getTime())>0)
				return -1;
			else
				return 0;
		}
	}
	
	/**
	 * Implemented here so that Event can access the methods written in subclasses
	 */
	public String getContact() {
		return "";
	}
	public String getHost() {
		return "";
	}

}
