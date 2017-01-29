package ds.queue.array;

public class QueueFullException extends Exception {

	private static final long serialVersionUID = 1L;

	public QueueFullException(String error) {
		super(error);
	}
}
