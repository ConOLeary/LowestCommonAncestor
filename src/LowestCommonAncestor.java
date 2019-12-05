import java.util.ArrayList;

class LowestCommonAncestor {
	
    private Node<Integer> ans1;
    private int ans2;

    public LowestCommonAncestor() {
        this.ans1 = null;
        this.ans2 = 0;
    }
    
    //***leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/solution
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
            this.ans1 = currentNode;
        }

        // Return true if any one of the three bool values is True.
        return (mid + left + right > 0);
    }

    private int lcaDag(int v, int w, int vertCount, int edgeCount, ArrayList<dag.dagEdge>[] edges){
		int[] vArr = new int[edgeCount];
		int[] wArr = new int[edgeCount];
		boolean[] vMarked = new boolean[vertCount+1];
		boolean[] wMarked = new boolean[vertCount+1];
		int vCount =0;
		int wCount = 0;
		vArr[vCount]=v;
		wArr[wCount]=w;
		for(int j=0; j<=vertCount;j++){//mark all vertices as not been visited yet
			vMarked[j]=false;
			wMarked[j]=false;
		}
		for(int i =1;i<=vertCount;i++){
			Integer vLoop = 0;
			vMarked[v] =true;
			wMarked[w] =true;
			for(int j = 0; j<edges[i].size();j++){
				vLoop = edges[i].get(j).v;
				if(vLoop==1 && vMarked[i]){
					vCount++;
					vArr[vCount]=j;
					vMarked[j]=true;
				}
				if(vLoop==1 && wMarked[i]){
					wCount++;
					wArr[wCount]=j;
					wMarked[j]=true;
				}
				if(wArr[wCount]==vArr[vCount]){
					ans2 = wArr[wCount];
					return wArr[wCount];
				}
			}
		}
		ans2 = -1;
		return -1;//returns -1 if no ancestor found
   }
    
    public Node<Integer> lowestCommonAncestorBT(Node<Integer> root, Node<Integer> p, Node<Integer> q) {
        // Traverse the tree
        this.recurseTree(root, p, q);
        return this.ans1;
    }//leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/solution***
    
    public int lowestCommonAncestorDAG(dag.Graph myDagGraph, int v, int w) {
    	int vertCount = myDagGraph.noOfVerts;
    	int edgeCount = myDagGraph.noOfEdges;
    	ArrayList<dag.dagEdge>[] edges = myDagGraph.adjacencyList;
        lcaDag(v, w, vertCount, edgeCount, edges);
        return ans2;
    }
}
