package ds.stack.linkedList;

public interface StackInterface {

	public int size();

	public boolean isEmpty();

	public void push(Object element);

	public Object top() throws StackEmptyException;

	public Object pop() throws StackEmptyException;

}
