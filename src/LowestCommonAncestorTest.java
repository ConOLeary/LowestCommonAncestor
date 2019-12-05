import static org.junit.Assert.*;

import org.junit.Test;

public class LowestCommonAncestorTest {
	LowestCommonAncestor lcaImplementation;
	Node<Integer> sampleHead;
	BinaryTree sampleTree;
	Node<Integer> node1;
	Node<Integer> node2;
	Node<Integer> node3;
	Node<Integer> node4;
	Node<Integer> node5;
	Node<Integer> node6;
	Node<Integer> ancestorBT;
	int ancestorDAG;
	dag.Graph myDagGraph;
	public LowestCommonAncestorTest()
	{
		lcaImplementation= new LowestCommonAncestor();
		sampleHead= new Node<Integer>(69);
		sampleTree= new BinaryTree(sampleHead);
		node1= new Node<Integer>(420);
		node2= new Node<Integer>(123);
		node3= new Node<Integer>(4210);
		node4= new Node<Integer>(12);
		node5= new Node<Integer>(9);
		node6= new Node<Integer>(1231);
		sampleTree.push(node1);
		sampleTree.push(node2);
		sampleTree.push(node3);
		sampleTree.push(node4);
		sampleTree.push(node5);
		sampleTree.push(node6);
		myDagGraph =new dag.Graph(7);
		myDagGraph.addEdge(1, 2);
		myDagGraph.addEdge(1, 3);
		myDagGraph.addEdge(2, 4);
		myDagGraph.addEdge(2, 5);
		myDagGraph.addEdge(3, 6);
		myDagGraph.addEdge(4, 7);
		myDagGraph.addEdge(5, 7);
		myDagGraph.addEdge(6, 7);
		//myDagGraph.addEdge(5, 1);
		//myDagGraph.printGraph();
		//System.out.print("ancestorDAG: "+ancestorDAG);
	}
	
	@Test
	public void LCAnormal() {
		System.out.print("data @ rightChild of head :"+sampleTree.head.getRightChild().getData().toString());
		ancestorBT= lcaImplementation.lowestCommonAncestorBT(sampleHead, node5, node3);
		assertEquals(ancestorBT,sampleHead);
	}
	@Test
	public void LCAnullInputs() {
		ancestorBT= lcaImplementation.lowestCommonAncestorBT(null, null, null);
		assertEquals(ancestorBT,null);
		ancestorBT= lcaImplementation.lowestCommonAncestorBT(sampleHead, null, null);
		assertEquals(ancestorBT,null);
		ancestorBT= lcaImplementation.lowestCommonAncestorBT(sampleHead, node1, null);
		assertEquals(ancestorBT,null);
	}
	@Test
	public void LCAotherEdgeCases() {
		ancestorBT= lcaImplementation.lowestCommonAncestorBT(sampleHead, node1, node1);
		assertEquals(ancestorBT,null);
		ancestorBT= lcaImplementation.lowestCommonAncestorBT(node1, node1, node1);
		assertEquals(ancestorBT,null);
	}
	@Test
	public void lcaDagNormal() {
		ancestorDAG= lcaImplementation.lowestCommonAncestorDAG(myDagGraph, 5, 7);
		assertEquals(ancestorDAG,6);
	}
}
