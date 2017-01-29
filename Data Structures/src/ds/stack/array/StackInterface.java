package ds.stack.array;

public interface StackInterface {

	public int size();

	public boolean isEmpty();

	public Object top() throws StackEmptyException;

	public Object pop() throws StackEmptyException;

	public void push(Object element) throws StackFullException;

}
