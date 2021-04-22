
/***
 * CLass to model a Meeting with super class Event
 * @author Christopher Vella
 * @version 0.1
 * Date of creation: February 22, 2021
 * Last Date Modified: March 11, 2021
 */
public class Meeting extends Event {
	//Data members
	private String host;
	
	/**
	 * Default constructor
	 * Initializes host to the string "none"
	 */
	public Meeting() {
		super();
		host = "none";
	}
	/**
	 * Constructor with five parameters
	 * @param description for the description of an Event
	 * @param date for the date of an Event
	 * @param time for the time of an Event
	 * @param location for the location of an Event
	 * @param host for the host of a Meeting
	 */
	public Meeting(String description, Date date, Time time, String location, String host) {
		super(description, date, time, location);
		this.host = host;
	}
	
	/**
	 * Getter for the host of a Meeting
	 * @param no parameters
	 * @return the value of the data member host
	 */
	public String getHost() {
		return host;
	}
	/**
	 * Setter for the host of a Meeting
	 * @param host to set the host of a Meeting
	 * @return no return value
	 */
	public void setHost(String host) {
		this.host = host;
	}
	/**
	 * Method to get the information of a Meeting
	 * @param no parameters
	 * @return formatted string containing the value of the data members
	 */
	public String toString() {
		return "Meeting\t\t" + super.toString() + getHost();
	}

}
