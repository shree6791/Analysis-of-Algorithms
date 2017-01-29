package ds.list.doublyLinkedList;

public class ListMain {

	public static void main(String[] args) throws ListEmptyException {

		ListDADT ld = new ListDADT();

		ld.insertAtLast(2);
		ld.insertAtLast(3);
		ld.insertAtStart(1);
		ld.insertAtPosition(1, 1.5);
		

		System.out.println("1st Element : " + ld.front());
		System.out.println("Last Element : " + ld.rear());
		System.out.println("List Size : " + ld.size());
		
		ld.removeAtStart();
		ld.removeAtLast();
		ld.removeAtPosition(1);
		
		System.out.println("1st Element : " + ld.front());
		System.out.println("List Size : " + ld.size());

	}

}
