public class Node<T> {
    private T data;
    private Node<T> parent;
    private Node<T> leftChild;
    private Node<T> rightChild;
    
    public Node(T nodeData) {
        this.setData(nodeData);
        this.setParent(null);
        this.setLeftChild(null);
        this.setRightChild(null);
    }
    
	public Node<T> getParent() {
		return parent;
	}

	public void setParent(Node<T> parent) {
		this.parent = parent;
	}
	
	public Node<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node<T> leftChild) {
		if(leftChild != null) leftChild.setParent(this);
		this.leftChild= leftChild;
	}

	public Node<T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node<T> rightChild) {
		if(leftChild != null) rightChild.setParent(this);
		this.rightChild = rightChild;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}