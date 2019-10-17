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
	Node<Integer> ancestor;
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
	}
	
	@Test
	public void LCAnormal() {
		System.out.print("data @ rightChild of head :"+sampleTree.head.getRightChild().getData().toString());
		ancestor= lcaImplementation.lowestCommonAncestor(sampleHead, node5, node3);
		assertEquals(ancestor,sampleHead);
	}
	@Test
	public void LCAnullInputs() {
		ancestor= lcaImplementation.lowestCommonAncestor(null, null, null);
		assertEquals(ancestor,null);
		ancestor= lcaImplementation.lowestCommonAncestor(sampleHead, null, null);
		assertEquals(ancestor,null);
		ancestor= lcaImplementation.lowestCommonAncestor(sampleHead, node1, null);
		assertEquals(ancestor,null);
	}
	@Test
	public void LCAotherEdgeCases() {
		ancestor= lcaImplementation.lowestCommonAncestor(sampleHead, node1, node1);
		assertEquals(ancestor,null);
		ancestor= lcaImplementation.lowestCommonAncestor(node1, node1, node1);
		assertEquals(ancestor,null);
	}
}
