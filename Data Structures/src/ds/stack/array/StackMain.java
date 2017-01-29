package ds.stack.array;

public class StackMain {

	public static void main(String[] args) throws StackEmptyException, StackFullException {

		StackArray sa = new StackArray();

		sa.push(1);
		sa.push(2);
		sa.push(3);
		sa.push(4);

		System.out.println(sa.top());

		sa.pop();
		sa.pop();
		sa.pop();
		sa.pop();

		System.out.println(sa.top());

	}

}
