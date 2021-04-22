import java.util.Iterator;
import java.util.NoSuchElementException;
/***
 * Generic class to model a LinkedList
 * @author Christopher Vella
 * @version 0.1
 * Date of Creation: April 9, 2021
 * Last Date Modified: April 16, 2021
 */
public class LinkedList<E> {
	// Data members
	private Node head, tail;
	int size;

	/**
	 * Inner class to create a Node
	 */
	private class Node {
		E value;
		Node next;

		/**
		 * Constructor with one parameter
		 * @param initialValue to set the initialValue of a Node
		 * Initializes next to null;
		 */
		Node(E initialValue) {
			value = initialValue;
			next = null;
		}
	}

	/**
	 * Default constructor
	 * Initializes head and tail to null, and size to the int 0
	 */
	public LinkedList() {// empty list O(1)
		head = tail = null;
		size = 0;
	}

	/**
	 * Method to add an item to the beginning of the a list
	 * @param item for the item to add the LinkedList
	 * @return boolean true if the item was added and false if it was not
	 */
	public boolean addFirst(E item) { // O(1)
		Node newNode = new Node(item);
		if (head == null) { // first element to be added
			head = tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		size++;
		return true;
	}

	/**
	 * Method to add an item to the end of a list
	 * @param item for the item to add the list
	 * @return boolean true if the item was added and false if it was not
	 */
	public boolean addLast(E item) { // O(1)
		Node newNode = new Node(item);
		if (head == null) { // first element to be added
			head = tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		size++;
		return true;
	}

	/**
	 * Method to add an item to the a list using the addFirst method
	 * @param item for the item to add the list
	 * @return boolean true if the item was added and false if it was not
	 */
	public boolean add(E item) { // O(1)
		return addFirst(item);
	}

	/**
	 * Method to retrieve the first item from the list
	 * @param no parameter
	 * @return the first item in the list
	 */
	public E getFirst() { // O(1)
		if (head == null)// list is empty
			throw new NoSuchElementException();
		return head.value;
	}

	/**
	 * Method to retrieve the last item from the list
	 * @param no parameter
	 * @return the first item in the list
	 */
	public E getLast() { // O(1)
		if (head == null)// list is empty
			throw new NoSuchElementException();
		return tail.value;
	}

	/**
	 * Method to remove the first item from the list
	 * @param no parameter
	 * @return boolean true if the item was removed added and false if it was not
	 */
	public boolean removeFirst() { // O(1)
		if (head == null)
			throw new NoSuchElementException();
		head = head.next;
		if (head == null) // removing one element from the list
			tail = null;
		size--;
		return true;
	}

	/**
	 * Method to remove the last item from the list
	 * @param no parameter
	 * @return boolean true if the item was removed added and false if it was not
	 */
	public boolean removeLast() { // O(n)
		if (head == null)
			throw new NoSuchElementException();
		if (size == 1)
			return removeFirst();
		Node current = head;
		Node previous = null;
		while (current.next != null) { // go to the element before the tail
			previous = current;
			current = current.next;
		}
		// previous becomes the new tail
		previous.next = null;
		tail = previous;
		size--;
		return true;
	}

	/**
	 * Method to get the information of a list
	 * @param no parameters
	 * @return formatted string containing the value of the data members
	 */
	public String toString() { // O(n)
		String output = "[";
		Node current = head;
		while (current != null) {
			output += current.value + " ";
			current = current.next; // move to the next node
		}
		output += "]";
		return output;
	}

	/**
	 * Method to clear the list
	 * @param no parameters
	 * @return no return value
	 */
	public void clear() { // O(1)
		head = tail = null;
		size = 0;
	}

	/**
	 * Method to check if the list is empty
	 * @param no parameters
	 * @return boolean true if the list is empty and false if it is not
	 */
	public boolean isEmpty() { // O(1)
		return (size == 0);
	}

	/**
	 * Method to get the size of a list
	 * @param no parameters
	 * @return the value of the size of the list
	 */
	public int size() { // O(1)
		return size;
	}

	/**
	 * Method to generate an iterator for the list
	 * @param no parameters
	 * @return an iterator for the inputed list
	 */
	public Iterator<E> iterator() {
		return new LinkedListIterator();
	}

	// Inner class to create an Iterator
	private class LinkedListIterator implements Iterator<E> {
		private Node current = head;

		/**
		 * Method to check if the iterator has a next value
		 * @param no parameters
		 * @return boolean true if the iterator has a next value and false if not
		 */
		public boolean hasNext() { // O(1)
			return (current != null);
		}

		/**
		 * Method to get the current value of the iterator and move current forward
		 * @param no parameters
		 * @return the value of the data member current
		 */
		public E next() { // O(1)
			if (current == null)
				throw new NoSuchElementException();
			E value = current.value;
			current = current.next;
			return value;
		}
	}

	/**
	 * Method to add an item to a specific index
	 * @param index the index to add the item at
	 * @param item to be added to the list
	 * @return boolean true if the item was added and false if it was not
	 */
	public boolean add(int index, E item) {	// O(n)
		if (index > size || index < 0)
			throw new ArrayIndexOutOfBoundsException();
		if (index == 0) {
			return addFirst(item);
		}
		if (index == size) {
			return addLast(item);
		}
		Node current = head;
		Node previous = null;
		int i = 0;
		while (i < index) {	// O(n) - worst case: adding an element at index size-1
			previous = current;
			current = current.next;
			i++;
		}
		Node newNode = new Node(item);
		previous.next = newNode;
		newNode.next = current; // inserting newNode between previous and current
		size++;
		return true;
	}
	
	/**
	 * Method to get an item at a specific  index
	 * @param index the index of the list to get the item from
	 * @return the value of the item at the index
	 */
	public E get(int index) { // O(n)
		if (index > size || index < 0)
			throw new ArrayIndexOutOfBoundsException();
		if (index == 0) {
			return getFirst();
		}
		if (index == size) {
			return getLast();
		}
		Node current = head;
		Node previous = null;
		int i = 0;
		while (i < index) {	// O(n) - worst case: adding an element at index size-1
			previous = current;
			current = current.next;
			i++;
		}
		E value = current.value;
		return value;
	}

}