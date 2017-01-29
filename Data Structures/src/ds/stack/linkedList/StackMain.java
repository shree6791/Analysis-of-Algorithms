package ds.stack.linkedList;

public class StackMain {

	public static void main(String[] args) throws StackEmptyException {

		StackLinkedList slt = new StackLinkedList();

		slt.push(1);
		slt.push(2);
		slt.push(3);
		slt.push(4);

		System.out.println(slt.top());

		slt.pop();
		slt.pop();
		slt.pop();
		slt.pop();
		
		System.out.println(slt.top());
		
	}

}
