package ds.hashmap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Temp {

	public static void main(String[] args) {

		int[] arr = new int[5];

		ArrayList<List<Integer>> as = new ArrayList<List<Integer>>();

		List<Integer> l = new LinkedList<Integer>();
		l.add(1);
		l.add(2);
		l.add(3);
		as.add(l);

		// Node n1 = new Node(5);
		// as.add(n1);
		// as.get(0).setNext(new Node(6));

		System.out.println(as.size());

	}

}
