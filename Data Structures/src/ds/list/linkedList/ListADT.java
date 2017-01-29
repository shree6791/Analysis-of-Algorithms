package ds.list.linkedList;

public class ListADT implements ListInterface {

	int size;
	Node head, tail;

	public ListADT() {
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Object rear() {
		return tail.getElement();
	}

	@Override
	public Object front() {
		return head.getElement();
	}
	
	@Override
	public boolean isEmpty() {
		if (size == 0)
			return true;
		return false;
	}

	@Override
	public void insertAtLast(Object element) {

		Node node = new Node(element);
		node.next = null;
		size++;

		if (head == null)
			head = node;
		else
			tail.setNext(node);

		tail = node;

	}

	@Override
	public void insertAtStart(Object element) {

		Node node = new Node(element);
		node.next = null;
		size++;

		if (head == null)
			head = node;
		else {
			Node after = head;
			head = node;
			head.setNext(after);
		}

	}

	@Override
	public void removeAtLast() throws ListEmptyException {

		if (size == 0)
			throw new ListEmptyException("List is Empty");

		Node current = head;

		while (current.next != tail)
			current = current.next;

		Object obj = current.next.getElement();
		System.out.println(obj);
		current.next = null;
		tail = current;
		size--;

	}

	@Override
	public void removeAtStart() throws ListEmptyException {

		if (size == 0)
			throw new ListEmptyException("List is Empty");
		else {
			System.out.println(head.getElement());
			head = head.next;
		}

	}

	@Override
	public void insertAtPosition(int position, Object element) {

		Node node = new Node(element);
		node.next = null;

		if (head == null)
			head = node;
		else {

			int count = 0;
			Node current = head;

			while (count < position - 1) {
				current = current.next;
				count++;
			}

			Node after = current.next;
			node.next = after;
			current.next = node;

		}

		size++;

	}

	@Override
	public void removeAtPosition(int position) throws ListEmptyException {

		Object obj;
		int count = 0;
		Node current = head;

		while (count < position - 1) {
			current = current.next;
			count++;
		}

		if (position == 0) {
			obj = head.getElement();
			head = head.next;
		} else {
			obj = current.next.getElement();
			Node after = current.next.next;
			current.next = null;
			current.next = after;
		}

		System.out.println(obj);
		size--;

	}

}
