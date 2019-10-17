class LowestCommonAncestor {

    private Node<Integer> ans;

    public LowestCommonAncestor() {
        // Variable to store LCA node.
        this.ans = null;
    }

    private boolean recurseTree(Node<Integer> currentNode, Node<Integer> p, Node<Integer> q) {

        // If reached the end of a branch, return false.
        if (currentNode == null) {
            return false;
        }

        // Left Recursion. If left recursion returns true, set left = 1 else 0
        int left = this.recurseTree(currentNode.getLeftChild(), p, q) ? 1 : 0;

        // Right Recursion
        int right = this.recurseTree(currentNode.getRightChild(), p, q) ? 1 : 0;

        // If the current node is one of p or q
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;


        // If any two of the flags left, right or mid become True
        if (mid + left + right >= 2) {
            this.ans = currentNode;
        }

        // Return true if any one of the three bool values is True.
        return (mid + left + right > 0);
    }

    public Node<Integer> lowestCommonAncestor(Node<Integer> root, Node<Integer> p, Node<Integer> q) {
        // Traverse the tree
        this.recurseTree(root, p, q);
        return this.ans;
    }
}
