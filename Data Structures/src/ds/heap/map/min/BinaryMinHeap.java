package ds.heap.map.min;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryMinHeap<T> {

	private List<Node<T>> allNodes = new ArrayList<>();
	private Map<T, Integer> nodePosition = new HashMap<>();

	public T min() {
		return allNodes.get(0).key;
	}

	public boolean isEmpty() {
		return allNodes.size() == 0;
	}

	public Node<T> extractMinNode() {

		Node<T> minNode = new Node<T>();
		minNode.key = allNodes.get(0).key;
		minNode.weight = allNodes.get(0).weight;

		int size = allNodes.size() - 1;
		int lastNodeWeight = allNodes.get(size).weight;

		allNodes.get(0).weight = lastNodeWeight;
		allNodes.get(0).key = allNodes.get(size).key;

		nodePosition.remove(minNode.key);
		nodePosition.put(allNodes.get(0).key, 0);

		int currentIndex = 0;
		allNodes.remove(size);
		size--;

		while (true) {

			int leftIndex = 2 * currentIndex + 1;
			int rightIndex = 2 * currentIndex + 2;

			if (leftIndex > size)
				break;

			if (rightIndex > size)
				rightIndex = leftIndex;

			int smallerIndex = allNodes.get(leftIndex).weight <= allNodes.get(rightIndex).weight ? leftIndex
					: rightIndex;

			if (allNodes.get(currentIndex).weight > allNodes.get(smallerIndex).weight) {

				swap(allNodes.get(currentIndex), allNodes.get(smallerIndex));
				updatePositionMap(allNodes.get(currentIndex).key, allNodes.get(smallerIndex).key, currentIndex,
						smallerIndex);
				currentIndex = smallerIndex;

			} else
				break;

		}
		System.out.println(minNode.weight);
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

	public void add(T key, int weight) {

		Node<T> node = new Node<T>();
		node.weight = weight;
		node.key = key;

		allNodes.add(node);
		int size = allNodes.size();

		int currentIndex = size - 1;
		int parentIndex = (currentIndex - 1) / 2;
		nodePosition.put(node.key, currentIndex);

		while (parentIndex >= 0) {

			Node<T> parentNode = allNodes.get(parentIndex);
			Node<T> currentNode = allNodes.get(currentIndex);

			if (parentNode.weight > currentNode.weight) {

				swap(parentNode, currentNode);
				updatePositionMap(parentNode.key, currentNode.key, parentIndex, currentIndex);
				currentIndex = parentIndex;
				parentIndex = (parentIndex - 1) / 2;

			} else
				break;
		}
	}

	public void decrease(T key, int newWeight) {

		Integer position = nodePosition.get(key);
		allNodes.get(position).weight = newWeight;
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

	public T extractMin() throws HeapEmptyException {

		if (isEmpty())
			throw new HeapEmptyException("Heap is Empty");
		else
			return extractMinNode().key;
	}

	private void swap(Node<T> node1, Node<T> node2) {

		T data = node1.key;
		int weight = node1.weight;

		node1.key = node2.key;
		node1.weight = node2.weight;

		node2.key = data;
		node2.weight = weight;

	}

	private void updatePositionMap(T data1, T data2, int pos1, int pos2) {

		// nodePosition.remove(data1);
		// nodePosition.remove(data2);
		nodePosition.put(data1, pos1);
		nodePosition.put(data2, pos2);

	}

	public static void main(String args[]) {

		BinaryMinHeap<String> heap = new BinaryMinHeap<String>();

		heap.add("Roy", 5);
		heap.add("NTF", 6);
		heap.add("AFR", 2);
		heap.add("Ani", 4);
		heap.add("Vijay", 8);
		heap.add("Tushar", 3);
		heap.add("Pramila", 10);

		heap.decrease("Pramila", 1);

		heap.extractMinNode();
		heap.extractMinNode();
		heap.extractMinNode();
		heap.extractMinNode();
		heap.extractMinNode();
		heap.extractMinNode();
		heap.extractMinNode();

	}
}
