package ds.list.linkedList;

public class ListMain {

	public static void main(String[] args) throws ListEmptyException {

		ListADT li = new ListADT();

		li.insertAtLast(1);
		li.insertAtLast(2);
		li.insertAtLast(3);
		li.insertAtLast(4);

		li.insertAtStart(0);
		li.insertAtPosition(1, 0.5);
		li.insertAtPosition(3, 1.5);
		
		System.out.println("List Size " + li.size);
		System.out.println("1st Element in List " + li.front());
		System.out.println("Last Element in List " + li.rear());

		li.removeAtLast();
		li.removeAtLast();
		li.removeAtStart();
		li.removeAtPosition(2);
		li.removeAtPosition(1);

		System.out.println("List Size " + li.size);
		
	}

}
