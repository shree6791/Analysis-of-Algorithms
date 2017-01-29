package ds.queue.linkedList;

public class QueueMain {

	public static void main(String[] args) throws QueueEmptyException {

		QueueLinkedList qll = new QueueLinkedList();

		qll.insertAtPosition(0, 0);

		qll.enqueue(1);
		qll.enqueue(2);
		qll.enqueue(3);
		qll.enqueue(4);

		qll.insertAtPosition(5, 5);
		//qll.insertAtPosition(0, -1);
		//qll.insertAtPosition(2, 6);

		System.out.println("Queue Elements in Order -->");
		qll.printQueueElements(qll.head);
				
		Node reverse = qll.reverseQueueOrder(qll.head);	
		System.out.println("\n\nQueue in Reverse Order -->  ");
		qll.printQueueElements(reverse);
		
		System.out.println("\n\nElement in Front of Queue " + qll.front());

		qll.dequeue();
		qll.dequeue();
		qll.dequeue();
		qll.dequeue();

		System.out.println("Element in Front of Queue " + qll.front());
	}

}
