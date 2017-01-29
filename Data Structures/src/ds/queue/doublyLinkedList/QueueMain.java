package ds.queue.doublyLinkedList;

public class QueueMain {

	public static void main(String[] args) throws QueueEmptyException {

		QueueDoubleLinkedList qdlt = new QueueDoubleLinkedList();

		qdlt.enqueue(1);
		qdlt.enqueue(2);
		qdlt.enqueue(3);
		qdlt.enqueue(4);

		System.out.println(qdlt.front());

		qdlt.dequeue();
		qdlt.dequeue();
		qdlt.dequeue();
		qdlt.dequeue();

		System.out.println(qdlt.front());
	}

}
