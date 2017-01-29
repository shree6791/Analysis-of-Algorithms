package ds.list.linkedList;

public interface ListInterface {

	public int size();

	public Object rear();

	public Object front();
	
	public boolean isEmpty();

	public void insertAtLast(Object element);

	public void insertAtStart(Object element);

	public void removeAtLast() throws ListEmptyException;

	public void removeAtStart() throws ListEmptyException;

	public void insertAtPosition(int position, Object element);

	public void removeAtPosition(int position) throws ListEmptyException;

}
