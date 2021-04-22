
/**
 * CLass to create an exception for an invalid date that extends from the class Excpetion
 * @author Christopher Vella
 * @version 0.1
 * Date of Creation: February 22, 2021
 * Last Date Modified: March 3, 2021
 */
public class InvalidDateException extends Exception {
	/**
	 * Default constructor that passes an error message to the super class Exception
	 */
	public InvalidDateException() {
		super("Invalid Date.");
	}
	/**
	 * Constructor with one parameter
	 * @param message for the message of the InvalidDate
	 */
	public InvalidDateException(String message) {
		super(message);
	}

}
