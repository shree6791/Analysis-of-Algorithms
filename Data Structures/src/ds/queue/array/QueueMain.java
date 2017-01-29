package ds.queue.array;

public class QueueMain {

	public static void main(String[] args) throws QueueEmptyException, QueueFullException {

		QueueArray qa = new QueueArray();

		qa.enqueue(1);
		qa.enqueue(2);
		qa.enqueue(3);

		qa.dequeue();
		System.out.println(qa.front());

		qa.enqueue(4);
		qa.enqueue(5);
		qa.dequeue();
		System.out.println(qa.front());

		qa.enqueue(6);
		System.out.println(qa.front());

		qa.dequeue();
		qa.dequeue();
		qa.dequeue();
		qa.dequeue();

		System.out.println(qa.front());
	}

}
