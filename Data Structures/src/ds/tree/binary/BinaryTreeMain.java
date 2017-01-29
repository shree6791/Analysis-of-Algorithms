package ds.tree.binary;

public class BinaryTreeMain {

	public static void main(String[] args) throws ElementNotFoundException {

		// static Node root = new Node();
		BinaryTree bt = new BinaryTree();
		bt.insertElement(5);
		bt.insertElement(3);
		bt.insertElement(7);
		bt.insertElement(2);
		bt.insertElement(6);
		bt.insertElement(4);
		bt.insertElement(8);

		// Depth of Tree
		System.out.println("\nDepth of Tree : " + bt.depthOfTree(bt.root));

		// Lowest Common Ancestor
		System.out.print("\nLowest Common Ancestor of BST for Vetices 2 & 4 is ");
		Node lca = bt.lowestCommonAncestor(bt.root, 2, 4);
		System.out.println(lca.element);

		// Find Element
		System.out.print("\nFind Element 9");
		Node found = bt.findElement(9, bt.root);
		if (found != null)
			System.out.println("\nElement Found");
		else
			System.out.println("\nElement not Found");

		// Delete Node
		bt.deleteNode(2, bt.root);

		// Leaf Count
		System.out.println("\nLeaf Count " + bt.leafCount(bt.root));

		// Pre - Order Traversal
		System.out.println("\nPre - Order Traversal");
		bt.depth = bt.depthOfTree(bt.root);
		bt.preOrderTraversal(bt.root);

		// Post - Order Traversal
		System.out.println("\n\nPost - Order Traversal");
		bt.postOrderTraversal(bt.root);

		// In - Order Traversal
		System.out.println("\n\nIn - Order Ttaversal");
		bt.inOrderTraversal(bt.root);

		// Level Order Traversal
		System.out.println("\n\nLevel Order Traversal");
		bt.levelOrderTraversal(bt.root);

		// Top View of Tree
		System.out.println("\n\nTop View of Tree");
		bt.topView(bt.root);

	}

}
