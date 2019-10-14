
public class LowestCommonAncestor {

	public static void main(String args[])
	{
		Node<Integer> sampleHead= new Node<Integer>(69);
		BinaryTree sampleTree= new BinaryTree(sampleHead);
		Node<Integer> node1= new Node<Integer>(420);
		sampleTree.push(node1);
		System.out.print("data @ rightChild of head :"+sampleTree.head.getRightChild().getData().toString());
	}
	
	public static Node<String> findLCA(Node<String> A, Node<String> B, BinaryTree tree)
	{
		return null;
	}

}
