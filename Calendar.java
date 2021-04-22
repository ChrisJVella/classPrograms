import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/***
 * Class to model a Calendar
 * @author Christopher Vella
 * @version 0.1
 * Date of Creation: February 22, 2021
 * Last Date Modified: March 11, 2021
 */
public class Calendar {
	//Data members
	Event[] eventList;
	int count;
	
	/**
	 * Default constructor
	 * Initializes array eventList to length 100 of type Event and count to the int 0
	 */
	public Calendar() {
		eventList = new Event[100];
		count = 0;
	}
	/**
	 * Constructor with one parameter
	 * @param filename to determine what file to create instances of either meeting or appointment, then put the objects into the array eventList
	 */
	public Calendar(String filename) {
		eventList = new Event[100];
		count = 0;
		File file = new File(filename);
		Scanner readFile = null;
		try {
			readFile = new Scanner(file);
		}
		catch(FileNotFoundException e) {
			System.out.println("File " + filename + " not found.");
			System.exit(0);
		}
		while(readFile.hasNext()) {
			String type = readFile.next().toLowerCase();
			String d = readFile.next();
			int month = Integer.parseInt(d.substring(0,2));
			int day = Integer.parseInt(d.substring(3,5));
			int year = Integer.parseInt(d.substring(6,10));
			Date date = new Date(month, day, year);
			String t = readFile.next();
			int hours = Integer.parseInt(t.substring(0,2));
			int minutes = Integer.parseInt(t.substring(3,5));
			Time time = new Time(hours, minutes);
			String location = readFile.next();
			location += readFile.nextLine();
			String description = readFile.next();
			description += readFile.nextLine();
			if(type.equals("appointment")) {
				String contact = readFile.next();
				contact += readFile.nextLine();
				eventList[count++] = new Appointment(description, date, time, location, contact);
			}
			else if(type.equals("meeting")) {
				String host = readFile.next();
				host += readFile.nextLine();
				eventList[count++] = new Meeting(description, date, time, location, host);
			}
		}
	}
	
	/**
	 * Method to find an Event based on its description
	 * @param d for the description of the Event to found
	 * @return the Event with the same description as d or null if not found
	 */
	public Event findEvent(String d) {
		for(int i=0; i<count; i++)
			if(eventList[i].getDescription().toLowerCase().equals(d))
				return eventList[i];
		return null;
	}
	
	/**
	 * Method to add an Event to the array eventList
	 * @param e for the Event to add
	 * @return boolean true if the Event was added and false if the array was full
	 */
	public boolean addEvent(Event e) {
		if(count<100) {
			eventList[count++] = e;
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Method to remove an Event from the array eventList
	 * @param e for the Event to remove
	 * @return boolean true if the Event was removed and false if it was not
	 */
	public boolean removeEvent(Event e) {
		int index = -1;
		for(int i=0; i<count; i++) 
			if(e.toString().equals(eventList[i].toString()))
				index = i;
		if(!(index == -1)) {
			for(int i = index; i < count - 1; i++)
				eventList[i] = eventList[i + 1];
			eventList[count-1] = null;
			count--;
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Method to print all of the events in eventList
	 * @param no parameters
	 * @return no return value
	 */
	public void viewAllEvent() {
		System.out.println("Type\t\tDate\t\tTime\tLocation\t\tDescription\t\tHost/Contact");
		System.out.println("---------------------------------------------------------------------------------------------------------");
		for(int i=0; i<count; i++) {
			System.out.println(eventList[i].toString());
		}
	}
	
	/**
	 * Method to sort the array eventList based on the Event's Date and Time
	 * @param no parameters
	 * @return no return value
	 */
	public void sortEvent() {
		Event[] temp = new Event[count];
		for(int i=0; i<temp.length; i++) {
			temp[i] = eventList[i];
		}
		java.util.Arrays.sort(temp);
		for(int i=0; i<temp.length; i++) {
			eventList[i] = temp[i];
		}
	}
	
	/**
	 * Method to save the array eventList to a file
	 * @param filename determines what file eventList is saved to
	 * @return no return value
	 */
	public void saveToFile(String filename) {
		try {
			PrintWriter fileWrite = new PrintWriter(filename);
			System.out.println("\nFile " + filename + " opened for writing successfully.");
			for(int i=0; i<count; i++) {
				if(eventList[i] instanceof Appointment) {
					fileWrite.println("appointment");
					fileWrite.println(eventList[i].getDate());
					fileWrite.println(eventList[i].getTime());
					fileWrite.println(eventList[i].getLocation());
					fileWrite.println(eventList[i].getDescription());
					fileWrite.println(eventList[i].getContact());
				}
				else if(eventList[i] instanceof Meeting) {
					fileWrite.println("meeting");
					fileWrite.println(eventList[i].getDate());
					fileWrite.println(eventList[i].getTime());
					fileWrite.println(eventList[i].getLocation());
					fileWrite.println(eventList[i].getDescription());
					fileWrite.println(eventList[i].getHost());
				}
			}
			System.out.println("Writing Data to file: " + filename);
			fileWrite.close();
		} catch (FileNotFoundException e) {
			System.out.println("File " + filename + " not found.");
		}
	}

}
