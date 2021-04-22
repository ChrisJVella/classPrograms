import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;
/**
 * Test Java file to implement a LinkedList and DoublyLinkedList
 * @author Christopher Vella
 * @version 0.1
 * Date of Creation: April 9, 2021
 * Last Date Modified: April 16, 2021
 */
public class Test {

	public static void main(String[] args) {
		// Creates a LinkedList and a DoublyLinkedList
		LinkedList<String> countryLL = new LinkedList<>();
		DoublyLinkedList<String> countryDLL = new DoublyLinkedList<>();
		
		// Reads information from the file "coutries.txt" and adds the information into the LinkedList and DoublyLikedList
		String filename = "countries.txt";
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
			String country = readFile.nextLine();
			countryLL.addLast(country);
			countryDLL.addLast(country);
		}
		
		// Prints the LinkedList and DoublyLinkedList both forwards and backwards
		System.out.println("Linked List (Forward):");
		printLLForward(countryLL);
		System.out.println("\n\nLinked List (Backward):");
		printLLBackward(countryLL);
		System.out.println("\nDoubly Linked List (Forward):");
		printDLLForward(countryDLL);
		System.out.println("\n\nDoubly Linked List (Backward):");
		printDLLBackward(countryDLL);

	}
	
	/**
	 * Method to print a LinkedList forwards
	 * @param <E> the type of the data members in the LinkedList
	 * @param list the LinkedList to be printed
	 */
	public static <E> void printLLForward(LinkedList<E> list) {
		//System.out.println(list);
		Iterator<E> iter = list.iterator();
		System.out.print("[");
		while(iter.hasNext())
			System.out.print(iter.next() + " ");
		System.out.print("]");
	}
	
	/**
	 * Method to print a LinkedList backwards
	 * @param <E> the type of the data members in the LinkedList
	 * @param list the LinkedList to be printed
	 */
	public static <E> void printLLBackward(LinkedList<E> list) {
		System.out.print("[");
		for(int i=list.size-1; i>=0; i--) {
			System.out.print(list.get(i) + " ");
		}
		System.out.print("]\n");
	}
	
	/**
	 * Method to print a DoublyLinkedList forwards
	 * @param <E> the type of the data members in the DoublyLinkedList
	 * @param list the DoublyLinkedList to be printed
	 */
	public static <E> void printDLLForward(DoublyLinkedList<E> list) {
		ListIterator<E> iter = list.iterator();
		System.out.print("[");
		while(iter.hasNext())
			System.out.print(iter.next() + " ");
		System.out.print("]");
	}
	
	/**
	 * Method to print a DoublyLinkedList backwards
	 * @param <E> the type of the data members in the DoublyLinkedList
	 * @param list the DoublyLinkedList to be printed
	 */
	public static <E> void printDLLBackward(DoublyLinkedList<E> list) {
		ListIterator<E> iter = list.iterator(list.size);
		System.out.print("[");
		while(iter.hasNext())
			System.out.print(iter.previous() + " ");
		System.out.print("]");
	}

}
