
public class LowestCommonAncestor {
	
	
	//Integrated from www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1
	public static Node<Integer> findLCA(Node<Integer> node, Integer n1, Integer n2)
	{
        // Base case 
        if (node == null) 
            return null; 
  
        // If either n1 or n2 matches with root's key, report 
        // the presence by returning root (Note that if a key is 
        // ancestor of other, then the ancestor key becomes LCA 
        if (node.getData() == n1 || node.getData() == n2) 
            return node; 
  
        // Look for keys in left and right subtrees 
        Node<Integer> left_lca = findLCA(node.getLeftChild(), n1, n2); 
        Node<Integer> right_lca = findLCA(node.getRightChild(), n1, n2); 
  
        // If both of the above calls return Non-NULL, then one key 
        // is present in once subtree and other is present in other, 
        // So this node is the LCA 
        if (left_lca!=null && right_lca!=null) 
            return node; 
  
        // Otherwise check if left subtree or right subtree is LCA 
        return (left_lca != null) ? left_lca : right_lca; 
	}

}
