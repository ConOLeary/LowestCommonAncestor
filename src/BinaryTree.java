
public class BinaryTree {
	public Node<Integer> head;
	
    public BinaryTree(Node<Integer> head) {
        this.head= head;
    }
    
    public void push(Node<Integer> newNode) {
    		push(newNode, head);
    }
    private void push(Node<Integer> newNode, Node<Integer> current) {
    		if(current.getData() >= head.getData())
    		{
    			Node<Integer> rightChild= current.getRightChild();
    			if(rightChild == null)
    				current.setRightChild(newNode);
    			else
    				push(newNode, rightChild);
    		}
    		else
    		{
    			Node<Integer> leftChild= current.getLeftChild();
    			if(leftChild == null)
    				current.setLeftChild(newNode);
    			else
    				push(newNode, leftChild);
    		}
    }
    
}