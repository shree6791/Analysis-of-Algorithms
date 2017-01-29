package ds.graph.adjacency.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryMinHeap<T> {

	private List<Node> allNodes = new ArrayList<>();
	private Map<T, Integer> nodePosition = new HashMap<>();

	public T min() {
		return allNodes.get(0).key;
	}

	public class Node {
		T key;
		int weight;
	}

	public T extractMin() {
		Node node = extractMinNode();
		return node.key;
	}

	public boolean empty() {
		return allNodes.size() == 0;
	}

	public Node extractMinNode() {

		Node minNode = new Node();
		minNode.key = allNodes.get(0).key;
		minNode.weight = allNodes.get(0).weight;

		int size = allNodes.size() - 1;
		int lastNodeWeight = allNodes.get(size).weight;

		allNodes.get(0).weight = lastNodeWeight;
		allNodes.get(0).key = allNodes.get(size).key;

		nodePosition.remove(minNode.key);
		nodePosition.remove(allNodes.get(0));
		nodePosition.put(allNodes.get(0).key, 0);

		int currentIndex = 0;
		allNodes.remove(size);
		size--;

		while (true) {

			int left = 2 * currentIndex + 1;
			int right = 2 * currentIndex + 2;

			if (left > size)
				break;

			if (right > size)
				right = left;

			int smallerIndex = allNodes.get(left).weight <= allNodes.get(right).weight ? left : right;

			if (allNodes.get(currentIndex).weight > allNodes.get(smallerIndex).weight) {
				
				swap(allNodes.get(currentIndex), allNodes.get(smallerIndex));
				updatePositionMap(allNodes.get(currentIndex).key, allNodes.get(smallerIndex).key, currentIndex,
						smallerIndex);
				currentIndex = smallerIndex;
				
			} else
				break;

		}
		return minNode;
	}
	
	public Integer getWeight(T key) {

		Integer position = nodePosition.get(key);

		if (position == null)
			return null;
		else
			return allNodes.get(position).weight;

	}

	public boolean containsData(T key) {
		return nodePosition.containsKey(key);
	}

	public void add(int weight, T key) {

		Node node = new Node();
		node.weight = weight;
		node.key = key;

		allNodes.add(node);
		int size = allNodes.size();

		int current = size - 1;
		int parentIndex = (current - 1) / 2;
		nodePosition.put(node.key, current);

		while (parentIndex >= 0) {

			Node currentNode = allNodes.get(current);
			Node parentNode = allNodes.get(parentIndex);

			if (parentNode.weight > currentNode.weight) {

				swap(parentNode, currentNode);
				updatePositionMap(parentNode.key, currentNode.key, parentIndex, current);
				current = parentIndex;
				parentIndex = (parentIndex - 1) / 2;

			} else
				break;
		}
	}

	public void decrease(T data, double newWeight) {

		Integer position = nodePosition.get(data);
		allNodes.get(position).weight = (int)newWeight;
		int parent = (position - 1) / 2;

		while (parent >= 0) {

			if (allNodes.get(parent).weight > allNodes.get(position).weight) {

				swap(allNodes.get(parent), allNodes.get(position));
				updatePositionMap(allNodes.get(parent).key, allNodes.get(position).key, parent, position);
				position = parent;
				parent = (parent - 1) / 2;

			} else
				break;

		}
	}
	
	public void printHeap() {

		for (Node n : allNodes)
			System.out.println(n.weight + " " + n.key);

	}

	private void printPositionMap() {
		System.out.println(nodePosition);
	}

	private void swap(Node node1, Node node2) {

		T data = node1.key;
		int weight = node1.weight;

		node1.key = node2.key;
		node1.weight = node2.weight;

		node2.key = data;
		node2.weight = weight;

	}

	private void updatePositionMap(T data1, T data2, int pos1, int pos2) {

		nodePosition.remove(data1);
		nodePosition.remove(data2);
		nodePosition.put(data1, pos1);
		nodePosition.put(data2, pos2);

	}

	public static void main(String args[]) {

		BinaryMinHeap<String> heap = new BinaryMinHeap<String>();

		heap.add(5, "Roy");
		heap.add(6, "NTF");
		heap.add(2, "AFR");
		heap.add(4, "Ani");
		heap.add(8, "Vijay");
		heap.add(3, "Tushar");
		heap.add(10, "Pramila");

		heap.decrease("Pramila", 1);

		heap.printHeap();
		heap.printPositionMap();
	}
}
