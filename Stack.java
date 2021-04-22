import java.util.EmptyStackException;

public class Stack<E> {
	private ArrayList<E> elements;

	public Stack() {	// O(1)
		elements = new ArrayList<>();
	}

	public int size() {	// O(1)
		return elements.size();
	}

	public boolean isEmpty() {	// O(1)
		return elements.isEmpty();
	}

	public void push(E item) {	// O(1) best case, O(n) if arraylist resized
		elements.add(item);
	}

	public E peek() {	// O(1)
		if (isEmpty())
			throw new EmptyStackException();
		return elements.get(size() - 1); // top element
	}

	public E pop() {	// O(1)
		if (isEmpty())
			throw new EmptyStackException();
		E value = peek();
		elements.remove(size() - 1); // remove top
		return value;
	}

	public String toString() {	// O(n)
		return "Stack: " + elements.toString();
	}
}
