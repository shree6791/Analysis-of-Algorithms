package ds.stack.array;

public class StackArray implements StackInterface {

	private int size, index;
	private Object[] stackArray;
	private final int MAX_SIZE = 5;

	public StackArray() {
		size = -1;
		index = 0;
		stackArray = new Object[MAX_SIZE];
	}

	@Override
	public int size() {
		return size + 1;
	}

	@Override
	public boolean isEmpty() {
		if (size == -1)
			return true;
		return false;
	}

	@Override
	public Object top() throws StackEmptyException {

		if (isEmpty() == true)
			throw new StackEmptyException("Stack is Empty");
		else
			return stackArray[index - 1];
	}

	@Override
	public Object pop() throws StackEmptyException {

		if (isEmpty() == true)
			throw new StackEmptyException("Stack is Empty");

		Object element = stackArray[index - 1];
		stackArray[index - 1] = null;

		size--;
		index--;
		return element;
	}

	@Override
	public void push(Object element) throws StackFullException {

		if (size > MAX_SIZE - 1)
			throw new StackFullException("Stack is Full");

		stackArray[index] = element;
		size++;
		index++;

	}

}
