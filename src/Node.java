public class Node<T> {
    private T data;
    private Node<T> parent;
    private Node<T> leftChild;
    private Node<T> rightChild;
    
    public Node(T nodeData) {
        this.data= nodeData;
        this.parent= null;
        this.leftChild= null;
        this.rightChild= null;
    }
}