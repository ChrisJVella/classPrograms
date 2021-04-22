import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Test Java file to implement objects of Meeting and Appointment using information from a text file
 * and modify those objects using the class Calendar.
 * @author Christopher Vella
 * @version 0.1
 * Date of Creation: February 22, 2021
 * Last Date Modified: March 11, 2021
 */
public class CalendarManager {

	public static void main(String[] args) {
		//Creates a Calendar of information from the file "events.txt"
		Calendar myCalendar = new Calendar("events.txt");
		Scanner keyboard = new Scanner(System.in);
		int operation;
		String check = "";
		boolean running = true;
		do {
			// Prints a menu of operations to choose from
			printMenu();
			try {
				operation = keyboard.nextInt();
				check = keyboard.nextLine();
				if(check.length()!=0)
					throw new InputMismatchException();
				switch (operation) {
				case 0: // Prevents any looping errors
					System.out.println("Invalid Input -- Enter int 1-6");
					break;
				case 1: // Find an event with a given description
					System.out.println("Enter description: ");
					String desc = keyboard.next().toLowerCase();
					desc += keyboard.nextLine().toLowerCase();
					Event eTemp = myCalendar.findEvent(desc);
					if (!(eTemp == null))
						System.out.println("Event found: \n" + eTemp.toString());
					else
						System.out.println("Event not found.");
					break;
				case 2: // Add a new event
					try {
						System.out.println("Enter type of event(meeting/appointment): ");
						String type = keyboard.next();
						type += keyboard.nextLine();
						if (!(type.toLowerCase().equals("meeting") || type.toLowerCase().equals("appointment"))) {
							System.out.println("Not of type meeting or appointment.");
							break;
						}
						System.out.println("Enter description: ");
						String description = keyboard.next();
							description += keyboard.nextLine();
						System.out.println("Enter date(mm/dd/yyyy): ");
						String d = keyboard.next();
						d += keyboard.nextLine();
						checkDate(d);
						Date date = new Date(Integer.parseInt(d.substring(0, 2)), Integer.parseInt(d.substring(3, 5)), Integer.parseInt(d.substring(6, 10)));
						System.out.println("Enter time(hh:mm): ");
						String t = keyboard.next();
						checkTime(t);
						Time time = new Time(Integer.parseInt(t.substring(0, 2)), Integer.parseInt(t.substring(3, 5)));
						System.out.println("Enter location: ");
						String location = keyboard.next();
						location += keyboard.nextLine();
						if (type.toLowerCase().equals("appointment")) {
							System.out.println("Enter contact: ");
							String contact = keyboard.next();
							contact += keyboard.nextLine();
							boolean result = myCalendar.addEvent(new Appointment(description, date, time, location, contact));
							if (result)
								System.out.println("Event added successfully.");
							else
								System.out.println("Event not added.");
						} else if (type.toLowerCase().equals("meeting")) {
							System.out.println("Enter host: ");
							String host = keyboard.next();
							host += keyboard.nextLine();
							boolean result = myCalendar.addEvent(new Meeting(description, date, time, location, host));
							if (result)
								System.out.println("Event added successfully.");
							else
								System.out.println("Event not added.");
						}
					} catch (InvalidDateException e) {
						System.out.println(e.getMessage());
					} catch (InvalidTimeException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 3: // Remove an existing event
					System.out.println("Enter the description of the event: ");
					String descr = keyboard.next().toLowerCase();
					descr += keyboard.nextLine().toLowerCase();
					Event remove = myCalendar.findEvent(descr);
					if (remove == null) {
						System.out.println("Event not found.");
						break;
					}
					boolean b = myCalendar.removeEvent(remove);
					if (b) {
						System.out.println("Event found: ");
						System.out.println(remove.toString());
					}
					break;
				case 4: // View all events
					myCalendar.viewAllEvent();
					break;
				case 5: // Sort events based on Date and Time
					myCalendar.sortEvent();
					break;
				case 6: // Quit the program
					myCalendar.saveToFile("events.txt");
					System.out.println("-Exiting Program-");
					running = false;
					break;
				default:
					System.out.println("Invalid Input -- Enter int 1-6");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid Input -- Enter int 1-6");
				if(keyboard.hasNext())
					keyboard.next();
				operation = 0;
			}
		} while (running);
	}

	/**
	 * Method to print a list of operations
	 * @param no parameters
	 * @return no return value
	 */
	public static void printMenu() {
		System.out.println("\nChoose an operation: ");
		System.out.println("1. Find an event with a given description");
		System.out.println("2. Add a new event");
		System.out.println("3. Remove an existing event");
		System.out.println("4. View all events");
		System.out.println("5. Sort events");
		System.out.println("6. Quit the program");
	}

	/**
	 * Method to check an entered date for correct input
	 * @param date to check for validity
	 * @throws InvalidDateException if the date is invalid
	 */
	public static void checkDate(String date) throws InvalidDateException {
		if (!(date.matches("\\d{2}/\\d{2}/\\d{4}")))
			throw new InvalidDateException("Invalid Date Format");
		else if (Integer.parseInt(date.substring(3, 5)) < 1 || Integer.parseInt(date.substring(3, 5)) > 31)
			throw new InvalidDateException("Invalid day number -- must be from 1 to 31.");
		else if (Integer.parseInt(date.substring(0, 2)) < 1 || Integer.parseInt(date.substring(0, 2)) > 12)
			throw new InvalidDateException("Invalid month number -- must be from 1 to 12.");
		else if (Integer.parseInt(date.substring(6, 10)) < 1972 || Integer.parseInt(date.substring(6, 10)) > 2030)
			throw new InvalidDateException("Invalid year -- must be between 1972 to 2030.");
	}

	/**
	 * Method to check an entered time for correct input
	 * @param time to check for validity
	 * @throws InvalidTimeException if the date is invalid
	 */
	public static void checkTime(String time) throws InvalidTimeException {
		if (!(time.matches("\\d{2}:\\d{2}")))
			throw new InvalidTimeException("Invalid time format -- must be hh:mm.");
		else if (Integer.parseInt(time.substring(0, 2)) < 0 || Integer.parseInt(time.substring(0, 2)) > 23)
			throw new InvalidTimeException("Invalid hours -- must be from 0 to 23");
		else if (Integer.parseInt(time.substring(3, 5)) < 0 || Integer.parseInt(time.substring(3, 5)) > 59)
			throw new InvalidTimeException("Invalid minutes -- must be from 0 to 59");
	}

}
