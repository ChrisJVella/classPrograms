
public class BST<E extends Comparable<E>> {
	private TreeNode root;
	private int size;

	private class TreeNode {
		E value;
		TreeNode left;
		TreeNode right;

		TreeNode(E val) {
			value = val;
			left = right = null;
		}
	}

	BST() { // O(1)
		root = null;
		size = 0;
	}

	BST(E[] dataArray) { // O(n^2) - )(n log n)
		for (int i = 0; i < dataArray.length; i++)
			insert(dataArray[i]); // O(n) {O(log n)}
	}

	public int size() { // O(1)
		return size;
	}

	public boolean isEmpty() { // O(1)
		return (size == 0);
	}

	public void clear() { // O(1)
		root = null;
	}

	// Method search()
	public boolean search(E item) { // O(n) - worst case, O(log n) if the tree is balanced
		TreeNode current = root;
		while (current != null) {
			if (item.compareTo(current.value) < 0) // go to the left subtree
				current = current.left;
			else if (item.compareTo(current.value) > 0) // go to the right subtree
				current = current.right;
			else
				return true;
		}
		return false;
	}

	// Method insert()
	public boolean insert(E item) { // O(n) - worst case, O(log n) if the tree is balanced
		if (root == null) // first node to be inserted
			root = new TreeNode(item);
		else {
			TreeNode parent, current;
			parent = null;
			current = root;
			while (current != null) {// Looking for a leaf node
				parent = current;
				if (item.compareTo(current.value) < 0) { // go to left child
					current = current.left;
				} else if (item.compareTo(current.value) > 0) { // go to right child
					current = current.right;
				} else
					return false; // duplicates are not allowed
			}
			if (item.compareTo(parent.value) < 0)
				parent.left = new TreeNode(item);
			else
				parent.right = new TreeNode(item);
		}
		size++;
		return true;
	}

	// Method delete()
	public boolean delete(E item) { // O(n) - worst case, O(log n) if the tree is balanced 
		TreeNode parent, current;
		parent = null;
		current = root;
		// Find item first
		while (current != null) {
			if (item.compareTo(current.value) < 0) {
				parent = current;
				current = current.left;
			} else if (item.compareTo(current.value) > 0) {
				parent = current;
				current = current.right;
			} else
				break; // item found
		}
		if (current == null) // item not in the tree
			return false;
		// Case 1: node found and has no left child
		if (current.left == null) { // No left child
			if (parent == null) // delete root
				root = current.right;
			else {// modify link from parent to current’s child
				if (item.compareTo(parent.value) < 0)
					parent.left = current.right;
				else
					parent.right = current.right;
			}
		} else { // Case 2: current has a left child (has one left child or two children)
			TreeNode rightMostParent = current;
			TreeNode rightMost = current.left;
			// going right on left subtree
			while (rightMost.right != null) {
				rightMostParent = rightMost;
				rightMost = rightMost.right;
			}
			current.value = rightMost.value; // copy rightMost value into current node's value
			// delete rigthMost node
			if (rightMostParent.right == rightMost)
				rightMostParent.right = rightMost.left;
			else
				rightMostParent.left = rightMost.left;
		}
		size--;
		return true;
	}

	// Recursive method inorder()
	public void inorder() { // O(n)
		inorder(root);
	}

	private void inorder(TreeNode node) { // O(n)
		if (node != null) {
			inorder(node.left);
			System.out.print(node.value + " ");
			inorder(node.right);
		}
	}

	// Recursive method preorder()
	public void preorder() { // O(n)
		preorder(root);
	}

	private void preorder(TreeNode node) { // O(n)
		if (node != null) {
			System.out.print(node.value + " ");
			preorder(node.left);
			preorder(node.right);
		}
	}

	// Recursive method postorder()
	public void postorder() { // O(n)
		postorder(root);
	}

	private void postorder(TreeNode node) { // O(n)
		if (node != null) {
			postorder(node.left);
			postorder(node.right);
			System.out.print(node.value + " ");
		}
	}
	
	

}