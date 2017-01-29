package ds.tree.binary;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree implements BinaryTreeInterface {

	Node root;
	int depth, lCount;

	public void topView(Node node) {

		if (node != null) {
			topView(node.leftChild, true);
			System.out.print(node.element + " ");
			topView(node.rightChild, false);
		}

	}

	public int leafCount(Node node) {

		if (node.leftChild != null)
			leafCount(node.leftChild);

		if (node.rightChild != null)
			leafCount(node.rightChild);

		if (node.rightChild == null || node.leftChild == null)
			lCount++;

		return lCount;

	}

	public int depthOfTree(Node node) {

		if (node == null)
			return -1;
		else
			return 1 + Math.max(depthOfTree(node.leftChild), depthOfTree(node.rightChild));
	}

	public int minimumValue(Node node) {

		if (node.leftChild == null)
			return node.element;
		else
			return minimumValue(node.leftChild);

	}

	public boolean checkBST(Node node) {
		return checkBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public void inOrderTraversal(Node node) {

		if (node.leftChild != null)
			inOrderTraversal(node.leftChild);

		System.out.print(node.element + " ");

		if (node.rightChild != null)
			inOrderTraversal(node.rightChild);

	}

	public void preOrderTraversal(Node node) {

		int tempDepth = depthOfTree(node);
		int n = tempDepth % depth;

		if (node.rightChild == null && node.leftChild == null)
			n = depth;

		for (int i = 0; i < n; i++)
			System.out.print("| ");
		System.out.println(node.element);

		if (node.leftChild != null)
			preOrderTraversal(node.leftChild);

		if (node.rightChild != null)
			preOrderTraversal(node.rightChild);

	}

	public void postOrderTraversal(Node node) {

		if (node.leftChild != null)
			postOrderTraversal(node.leftChild);

		if (node.rightChild != null)
			postOrderTraversal(node.rightChild);

		System.out.print(node.element + " ");

	}

	public void levelOrderTraversal(Node node) {

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);

		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			System.out.print(temp.element + " ");

			if (temp.leftChild != null)
				queue.add(temp.leftChild);
			if (temp.rightChild != null)
				queue.add(temp.rightChild);
		}

	}

	public void insertElement(Integer element) {
		root = insertElement(root, new Node(element));
	}

	boolean checkBST(Node node, int min, int max) {

		if (node == null)
			return true;
		if (node.element <= min || node.element > max)
			return false;

		return checkBST(node.leftChild, min, node.element) && checkBST(node.rightChild, node.element, max);

	}

	public void topView(Node node, boolean goLeft) {

		if (node != null) {
			if (goLeft) {
				topView(node.leftChild, true);
				System.out.print(node.element + " ");
			} else {
				System.out.print(node.element + " ");
				topView(node.rightChild, false);
			}
		}

	}

	public Node insertElement(Node parent, Node node) {

		if (parent == null)
			return node;
		else if (node.element < parent.element)
			parent.leftChild = insertElement(parent.leftChild, node);
		else
			parent.rightChild = insertElement(parent.rightChild, node);

		return parent;

	}

	public Node findElement(Integer element, Node node) {

		if (node == null)
			return node;
		else if (element == node.element)
			return node;
		else if (element < node.element)
			return findElement(element, node.leftChild);
		else
			return findElement(element, node.rightChild);

	}

	public Node lowestCommonAncestor(Node node, int v1, int v2) {

		if (node.element > v1 && node.element > v2)
			node = lowestCommonAncestor(node.leftChild, v1, v2);
		else if (node.element < v1 && node.element < v2)
			node = lowestCommonAncestor(node.rightChild, v1, v2);

		return node;
	}

	public Node deleteNode(Integer element, Node node) throws ElementNotFoundException {

		if (node == null)
			throw new ElementNotFoundException("Element not present in Binary Tree");
		else if (node.element == element)
			node = null;
		else if (node.getElement() > element)
			node.leftChild = deleteNode(element, node.leftChild);
		else if (node.getElement() < element)
			node.rightChild = deleteNode(element, node.rightChild);
		else {

			if (node.rightChild == null)
				node = node.leftChild;
			else {
				int minVal = minimumValue(node.rightChild);
				node.element = minVal;
				node.rightChild = deleteNode(minVal, node.rightChild);
			}
		}
		return node;

	}

}
