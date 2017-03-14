public class BinarySearchTree {
	public Node root;
	public Node rootLooping;

	public void insert(int value) {
		Node node = new Node(value);

		if (root == null) {
			root = node;
			return;
		}

		insertWithRecursion(root, node);

		Node newNode = new Node(value);
		insertWithLoop(rootLooping, newNode);

	}

	private void insertWithRecursion(Node latestRoot, Node node) {

		if (latestRoot.value > node.value) {

			if (latestRoot.left == null) {
				latestRoot.left = node;
				return;
			} else {
				insertWithRecursion(latestRoot.left, node);
			}
		} else {
			if (latestRoot.right == null) {
				latestRoot.right = node;
				return;
			} else {
				insertWithRecursion(latestRoot.right, node);
			}
		}
	}

	private void insertWithLoop(Node root, Node newNode) {

		if (root == null) {
			root = newNode;
			return;
		}
		Node current = root;
		Node parent = null;
		while (true) {
			parent = current;
			if (newNode.value < current.value) {
				current = current.left;
				if (current == null) {
					parent.left = newNode;
					return;
				}
			} else {
				current = current.right;
				if (current == null) {
					parent.right = newNode;
					return;
				}
			}
		}
	}

	/**
	 * Returns the minimum value in the Binary Search Tree.
	 */
	public int findMinimum() {
		if (root == null) {
			return 0;
		}
		Node currNode = root;
		while (currNode.left != null) {
			currNode = currNode.left;
		}
		return currNode.value;
	}

	/**
	 * Returns the maximum value in the Binary Search Tree
	 */
	public int findMaximum() {
		if (root == null) {
			return 0;
		}

		Node currNode = root;
		while (currNode.right != null) {
			currNode = currNode.right;
		}
		return currNode.value;
	}

	/**
	 * Helper method to recursively print the contents in an inorder way
	 */
	private void printInOrderRec(Node currRoot) {
		if (currRoot == null) {
			return;
		}
		printInOrderRec(currRoot.left);
		System.out.print(currRoot.value + ", ");
		printInOrderRec(currRoot.right);
	}

	public boolean find(int id) {
		Node current = root;
		while (current != null) {
			if (current.value == id) {
				return true;
			} else if (current.value > id) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		return false;
	}

	public void displayPostOrder(Node root) {
		if (root != null) {
			displayPostOrder(root.left);
			displayPostOrder(root.right);
			System.out.print(root.value+", ");
		}
	}

	public void displayPreOrder(Node root) {
		if (root != null) {
			System.out.print(" " + root.value);
			displayPreOrder(root.left);
			displayPreOrder(root.right);
		}
	}

	public static void main(String arg[]) {
		BinarySearchTree b = new BinarySearchTree();
		b.insert(15);
		b.insert(10);
		b.insert(3);
		b.insert(8);
		b.insert(1);
		b.insert(4);
		b.insert(6);
		b.insert(2);
		b.insert(9);
		b.insert(20);
		b.insert(25);

		b.insert(16);

		System.out.println(" In  Order recursive");
		b.printInOrderRec(b.root);
		
		System.out.println("");
		System.out.println("Check whether Node with value 4 exists : " + b.find(4));
		System.out.println("Delete Node with no children (2) : " + b.delete(2));		
		b.printInOrderRec(b.root);
		System.out.println("\n Delete Node with one child (4) : " + b.delete(4));		
		b.printInOrderRec(b.root);
		System.out.println("\n Delete Node with Two children (10) : " + b.delete(10));		
		b.printInOrderRec(b.root);
		
		System.out.println("\n Delete Node with Two children (100) : " + b.delete(100));		
		b.printInOrderRec(b.root);

	}

	public boolean delete(int id) {
		Node parent = root;
		Node current = root;
		boolean isLeftChild = false;
		while (current.value != id) {
			parent = current;
			if (current.value > id) {
				isLeftChild = true;
				current = current.left;
			} else {
				isLeftChild = false;
				current = current.right;
			}
			if (current == null) {
				return false;
			}
		}
		// if i am here that means we have found the node
		// Case 1: if node to be deleted has no children
		if (current.left == null && current.right == null) {
			if (current == root) {
				root = null;
			}
			if (isLeftChild == true) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		}
		// Case 2 : if node to be deleted has only one child
		else if (current.right == null) {
			if (current == root) {
				root = current.left;
			} else if (isLeftChild) {
				parent.left = current.left;
			} else {
				parent.right = current.left;
			}
		} else if (current.left == null) {
			if (current == root) {
				root = current.right;
			} else if (isLeftChild) {
				parent.left = current.right;
			} else {
				parent.right = current.right;
			}
		} else if (current.left != null && current.right != null) {

			// now we have found the minimum element in the right sub tree
			Node successor = getSuccessor(current);
			if (current == root) {
				root = successor;
			} else if (isLeftChild) {
				parent.left = successor;
			} else {
				parent.right = successor;
			}
			successor.left = current.left;
		}
		return true;
	}

	public Node getSuccessor(Node deleleNode) {
		Node successsor = null;
		Node successsorParent = null;
		Node current = deleleNode.right;
		while (current != null) {
			successsorParent = successsor;
			successsor = current;
			current = current.left;
		}
		// check if successor has the right child, it cannot have left child for sure
		// if it does have the right child, add it to the left of
		// successsorParent
		if (successsor != deleleNode.right) {
			successsorParent.left = successsor.right;
			successsor.right = deleleNode.right;
		}
		return successsor;
	}
}

class Node {
	public int value;
	public Node left;
	public Node right;

	public Node(int value) {
		this.value = value;
	}

}