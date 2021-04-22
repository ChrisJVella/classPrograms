
/***
 * CLass to model an Appointment with super class Event
 * @author Christopher Vella
 * @version 0.1
 * Date of creation: February 22, 2021
 * Last Date Modified: March 11, 2021
 */
public class Appointment extends Event {
	//Data members
	private String contact;
	
	/**
	 * Default constructor
	 * Initializes contact to the string "none"
	 */
	public Appointment() {
		contact = "none";
	}
	/**
	 * Constructor with five parameters
	 * @param description for the description of an Event
	 * @param date for the date of an Event
	 * @param time for the time of an Event
	 * @param location for the location of an Event
	 * @param contact for the contact of an Appointment
	 */
	public Appointment(String description, Date date, Time time, String location, String contact) {
		super(description, date, time, location);
		this.contact = contact;
	}
	
	/**
	 * Getter for the contact of an Appointment
	 * @param no parameters
	 * @return the value of the data member contact
	 */
	public String getContact() {
		return contact;
	}
	/**
	 * Setter for the contact of an Appointment
	 * @param contact to set the contact of an Appointment
	 * @return no return value
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}
	/**
	 * Method to get the information of an Appointment
	 * @param no parameters
	 * @return formatted string containing the value of the data members
	 */
	public String toString() {
		return "Appointment\t" + super.toString() + getContact();
	}

}
