public class SinglyLinkedListNthNumber {
	public static void main(String args[]) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.append("1");
		list.append("2");
		list.append("3");
		list.append("4");
		System.out.println("linked list : " + list);
		System.out.println("The first node from last: " + list.getLastNode(1));
		System.out.println("The second node from the end: "
				+ list.getLastNode(2));
		System.out.println("The third node from the tail: "
				+ list.getLastNode(3));
		System.out.println("Does it has lop"+list.hasLoop());
	}
}

/** * Java Program to implement linked list data structure * * @author Javin * */
class SinglyLinkedList {
	static class Node {
		private Node next;
		private String data;

		public Node(String data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return data.toString();

		}

	}

	Node head;

	public String getLastNode(int n) {
		Node fast = head;
		Node slow = head;
		int start = 1;
		while (fast.next != null) {
			fast = fast.next;
			start++;
			if (start > n) {
				slow = slow.next;
			}
		}
		return slow.data;
	}

	/**
	 * * method to get the length of linked list * * @return length i.e. number
	 * of nodes in linked list
	 */
	public int length() {
		int length = 0;
		Node current = head;
		while (current != null) {
			length++;
			current = current.next;
		}
		return length;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node current = head;
		while (current != null) {
			sb.append(current).append("-->");
			current = current.next;
		}
		if (sb.length() >= 3) {
			sb.delete(sb.length() - 3, sb.length());
		}
		return sb.toString();
	}

	/**
	 * * returns the last node or tail of this linked list * * @return last node
	 */
	private Node tail() {
		Node tail = head;
		// Find last element of linked list known as tail
		while (tail.next != null) {
			tail = tail.next;
		}
		return tail;
	}

	boolean hasLoop() {

		if (head == null) // list does not exist..so no loop either.
			return false;

		Node slow, fast; // create two references.

		slow = fast = head; // make both refer to the start of the list.

		while (true) {

			slow = slow.next; // 1 hop.

			if (fast.next != null)
				fast = fast.next.next; // 2 hops.
			else
				return false; // next node null => no loop.

			if (slow == null || fast == null) // if either hits null..no loop.
				return false;

			if (slow == fast) // if the two ever meet...we must have a loop.
				return true;
		}
	}

	/** * appends a node at the tail of this linked list * * @param data */
	public void append(String data) {
		if (head == null) {
			head = new Node(data);
			return;
		}
		tail().next = new Node(data);
	}

}
