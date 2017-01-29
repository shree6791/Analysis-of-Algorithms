package ds.queue.array;

public class QueueEmptyException extends Exception {

	private static final long serialVersionUID = 1L;

	public QueueEmptyException(String error) {
		super(error);
	}
}
