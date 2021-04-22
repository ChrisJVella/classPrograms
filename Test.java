import java.util.Iterator;

public class Test {
	public static void main(String[] args) {
		// Testing the array list class
		ArrayList<String> cities = new ArrayList<>();
		cities.add("New York");
		cities.add("San Diego");
		cities.add("Atlanta");
		cities.add("Baltimore");
		cities.add("Pittsburg");
		System.out.println("\nArrayList");
		// toString() to display the content of the list
		System.out.println(cities.toString());
		// iterator to visit and display the elements of the list
		Iterator<String> cityIterator = cities.iterator();
		while (cityIterator.hasNext()) {
			System.out.print(cityIterator.next() + " ");
		}
		System.out.println();
		// get(index) to visit and display the elements of the list
		for (int i = 0; i < cities.size(); i++) {
			System.out.print(cities.get(i) + " ");
		}

		// Testing the linked list class
		LinkedList<String> cityList;
		cityList = new LinkedList<>();
		cityList.addFirst("Boston");
		cityList.addFirst("Philadelphia");
		cityList.addFirst("San Francisco");
		cityList.addFirst("Washington");
		cityList.addFirst("Portland");
		System.out.println("\n\nLinkedList");
		System.out.println(cityList.toString());
		Iterator<String> cityIteratorLL = cityList.iterator();
		System.out.print("City List (iterator): ");
		while (cityIteratorLL.hasNext()) {
			System.out.print(cityIteratorLL.next() + " ");
		}

		// Testing the stack class
		Stack<String> cityStack = new Stack<>();
		cityStack.push("New York");
		cityStack.push("San Diego");
		cityStack.push("Atlanta");
		cityStack.push("Baltimore");
		cityStack.push("Pittsburg");
		System.out.println("\n\nStack");
		System.out.println("City Stack (toString): " + cityStack.toString());
		System.out.print("City Stack (pop): ");
		while (!cityStack.isEmpty())
			System.out.print(cityStack.pop() + " ");

		// Testing the Queue class
		Queue<String> cityQueue = new Queue<>();
		cityQueue.offer("New York");
		cityQueue.offer("San Diego");
		cityQueue.offer("Atlanta");
		cityQueue.offer("Baltimore");
		cityQueue.offer("Pittsburg");
		System.out.println("\n\nQueue");
		System.out.println("City Queue (toString): " + cityQueue.toString());
		System.out.print("City Queue (poll): ");
		while (!cityQueue.isEmpty())
			System.out.print(cityQueue.poll() + " ");

		// Testing PriorityQueue class
		PriorityQueue<String> cityPriorityQueue = new PriorityQueue<>();
		cityPriorityQueue.offer("New York");
		cityPriorityQueue.offer("San Diego");
		cityPriorityQueue.offer("Atlanta");
		cityPriorityQueue.offer("Baltimore");
		cityPriorityQueue.offer("Pittsburg");
		System.out.println("\n\nPriorityQueue");
		System.out.println("City Priority Queue: " + cityPriorityQueue.toString());
		System.out.print("City Priority Queue (poll): ");
		while (!cityPriorityQueue.isEmpty()) {
			System.out.print(cityPriorityQueue.poll() + " ");
		}

		// Testing BST class
		BST<String> cityTree = new BST<>();
		cityTree.insert("New York");
		cityTree.insert("Washington");
		cityTree.insert("Boston");
		cityTree.insert("Philadelphia");
		cityTree.insert("Columbus");
		cityTree.insert("Baltimore");
		cityTree.insert("Atlanta");
		System.out.println("\n\nBST");
		System.out.print("Initial Tree: ");
		cityTree.inorder();
		System.out.println();
		cityTree.delete("Columbus");
		System.out.print("Tree after removal: ");
		cityTree.inorder();
		System.out.println();

		// Testing Heap class
		Heap<String> cityHeap = new Heap<>();
		cityHeap.insert("Atlanta");
		cityHeap.insert("Baltimore");
		cityHeap.insert("Boston");
		cityHeap.insert("Columbus");
		cityHeap.insert("New York");
		cityHeap.insert("Philadelphia");
		cityHeap.insert("Washington");
		System.out.print("\nHeap: ");
		System.out.println(cityHeap.toString());
	}
}
