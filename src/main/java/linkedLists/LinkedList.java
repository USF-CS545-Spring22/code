package linkedLists;

/** A class representing a linked list. */
public class LinkedList {
	private Node head, tail;

	public LinkedList() {
		head = null;
		tail = null;
	}

	/** Inserts a new node to the front of the list */
	public void insertAtFront(int elem) {
		Node newNode = new Node(elem);
		if (head == null) {
			head = newNode;
			tail  = newNode;
		}
		else {
			newNode.setNext(head);
			head = newNode;
		}
		/*if (head != null) {
			newNode.setNext(head);
		} else {
			tail = newNode;
		}
		head = newNode; */
	}

	/**
	 * Creates a new node with the given element and adds it to the back of the
	 * list
	 */
	public void append(int elem) {
		Node newNode = new Node(elem);
		if (tail != null) {
			tail.setNext(newNode);
			tail = newNode;
		} else {
			head = tail = newNode;
		}

	}

	/**
	 * Insert a given element at index i in the linked list
	 * @param index index where to insert
	 * @param elem element to insert
	 */
	public void insert(int index, int elem) {
		Node newNode = new Node(elem);
		if (head == null) {
			head = newNode;
			tail = newNode;
		}
		else if (index == 0) {
			newNode.setNext(head);
			head =  newNode;
		}
		else {
				Node prev = head;
				int count = 0;
				while (prev != null && count < index - 1) {
					prev = prev.next();
					count++;
				}
			    System.out.println("prev = " + prev.elem());

				if (prev != null) {
						//System.out.println(curr.elem());
						newNode.setNext(prev.next());
						prev.setNext(newNode);
				}
			}

	}
	/** Prints all the nodes in the link list */
	public void printNodes() {
		Node current = head;
		while (current != null) {
			System.out.print(current.elem() + " ");
			current = current.next();
		}
		System.out.println();

	}

	/** Return true if the given element is in the list */
	public boolean find(int elem) {
		Node current = head;
		while (current != null) {
			if (current.elem() == elem)
				return true;
			current = current.next();
		}
		return false;
	}


	/**
	 * Remove the node after "previousNode". Return the value of the element at
	 * the deleted node
	 */
	public int remove(Node previousNode) {
		if ((previousNode == null) || (previousNode.next() == null)) {
			System.out.println("Nothing to remove");
			return Integer.MAX_VALUE;
		}
		int elem = previousNode.next().elem();

		// if removing the tail
		if (previousNode.next() == tail) {
			tail = previousNode;
			tail.setNext(null);

		} else {
			// delete node
			previousNode.setNext(previousNode.next().next());
		}

		return elem;
	}

	public void insertElem(int elem, int index) {
			Node newNode = new Node(elem);
			Node current = head;
			if (index == 0 && head != null) {
				// insert before the head
				newNode.setNext(head);
				head = newNode;
				return;
			}
			int count = 0;
			while (current != null && (count < index  - 1)) {
				current  = current.next();
				count++;
			}
			//option 1:  I got out because current is null
			if (current == null) {
				if (index == 0) {
					head = newNode;
					tail = newNode;
				}
				else
					throw new IllegalArgumentException();
			}
			else {
				// We reached a node at index i - 1
				newNode.setNext(current.next());
				current.setNext(newNode);
				if (newNode.next() == null) {
					tail = newNode;
				}
			}





	}

	public ListIterator listIterator() {
		return new MyListIterator(0);
	}

	public class MyListIterator implements ListIterator {
		Node current = null;

		MyListIterator(int index) {
			current = head;
			int count = 0;
			while (current != null && count < index) {
				count++;
				current = current.next();
			}
		}

		public boolean hasNext() {
			return current != null;
		}

		public int next() {
			int elem = current.elem();
			current = current.next();
			return elem;
		}
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insertAtFront(40);
		list.insertAtFront(15);
		list.insertAtFront(34);
		list.printNodes();
		list.insertElem(55, 3);
		list.printNodes();

		ListIterator it = list.listIterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		/*list.printNodes();
		// System.out.println(list.find(1));
		System.out.println();
		list.insert(0, 4);
		list.printNodes();
		list.insert(1, 5);
		list.printNodes();
		list.insert(3, 88);
		list.printNodes();
		list.insert(5, 100);
		list.printNodes(); */

	}


}
