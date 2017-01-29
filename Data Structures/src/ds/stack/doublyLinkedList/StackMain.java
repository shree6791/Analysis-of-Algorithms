package ds.stack.doublyLinkedList;

public class StackMain {

	public static void main(String[] args) throws StackEmptyException {

		StackDoubleLinkedList sdlt = new StackDoubleLinkedList();

		sdlt.push(1);
		sdlt.push(2);
		sdlt.push(3);
		sdlt.push(4);

		System.out.println(sdlt.top());

		sdlt.pop();
		sdlt.pop();
		sdlt.pop();
		sdlt.pop();

		System.out.println(sdlt.top());

	}

}
