import java.util.Iterator;

public class PriorityQueue<E extends Comparable<E>> {
	private LinkedList<E> list;

	public PriorityQueue() {	// O(1)
		list = new LinkedList<>();
	}

	public void offer(E item) {	// O(n)
		Iterator<E> queueIterator = list.iterator();
		int index = 0;
		while (queueIterator.hasNext()) { // O(n)
			E current = queueIterator.next();
			if (item.compareTo(current) < 0) { // priority
				break;
			}
			index++;
		}
		list.add(index, item);// method in LinkedList O(n)
	}

	public E poll() {	// O(1)
		E value = list.getFirst();
		list.removeFirst();
		return value;
	}

	public E peek() {	// O(1)
		return list.getFirst();
	}

	public String toString() {	// O(n)
		return "Priority Queue: " + list.toString();
	}

	public int size() {	// O(1)
		return list.size();
	}

	public void clear() {	// O(1)
		list.clear();
	}

	public boolean isEmpty() {	// O(1)
		return list.size() == 0;
	}
}
