package ds.tree.binary;

public interface BinaryTreeInterface {

	boolean checkBST(Node node);
	
	public void topView(Node node);

	public int leafCount(Node node); 
	
	public int depthOfTree(Node node);
	
	public void inOrderTraversal(Node root);

	public void preOrderTraversal(Node root);

	public void postOrderTraversal(Node root);

	public void levelOrderTraversal(Node node);
	
	public void insertElement(Integer element);

	public Node findElement(Integer element, Node node);

	public Node lowestCommonAncestor(Node node, int v1, int v2);

	public Node deleteNode(Integer element, Node node) throws ElementNotFoundException;

}
