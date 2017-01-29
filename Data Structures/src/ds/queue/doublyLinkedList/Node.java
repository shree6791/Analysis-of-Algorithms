package ds.queue.doublyLinkedList;

public class Node {

	Object element;
	Node previousNode, nextNode;

	public Node() {
		super();
	}

	public Node(Object element, Node previousNode, Node nextNode) {
		super();
		this.element = element;
		this.previousNode = previousNode;
		this.nextNode = nextNode;
	}

	public Object getElement() {
		return element;
	}

	public void setElement(Object element) {
		this.element = element;
	}

	public Node getPreviousNode() {
		return previousNode;
	}

	public void setPreviousNode(Node previousNode) {
		this.previousNode = previousNode;
	}

	public Node getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}

}
