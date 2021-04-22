
/**
 * Class to create an exception for invalid callNumber's that extends from InputMismatchException
 * @author Christopher Vella
 * @version 0.1
 * Date of Creation: February 22, 2021
 * Last Date Modified: March 11, 2021
 */
public class InvalidTimeException extends Exception {
	/**
	 * Default constructor that passes an error message to the super class
	 */
	public InvalidTimeException() {
		super("Invalid Time.");
	}
	/**
	 * Constructor with one parameter
	 * @param message for the message of the InvalidDate
	 */
	public InvalidTimeException(String message) {
		super(message);
	}

}
