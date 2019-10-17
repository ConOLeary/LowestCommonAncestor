import static org.junit.Assert.*;

import org.junit.Test;

public class LowestCommonAncestorTest {
	
	public static void main(String args[])
	{

	}

	
	@Test
	public void testPopulation() {
		Node<Integer> sampleHead= new Node<Integer>(69);
		BinaryTree sampleTree= new BinaryTree(sampleHead);
		Node<Integer> node1= new Node<Integer>(420);
		Node<Integer> node2= new Node<Integer>(123);
		Node<Integer> node3= new Node<Integer>(4210);
		Node<Integer> node4= new Node<Integer>(12);
		Node<Integer> node5= new Node<Integer>(9);
		Node<Integer> node6= new Node<Integer>(1231);
		sampleTree.push(node1);
		sampleTree.push(node2);
		sampleTree.push(node3);
		sampleTree.push(node4);
		sampleTree.push(node5);
		sampleTree.push(node6);
		System.out.print("data @ rightChild of head :"+sampleTree.head.getRightChild().getData().toString());
		assertEquals("a","a");
		LowestCommonAncestor lcaImplementation= new LowestCommonAncestor();
		Node<Integer> ancestor= lcaImplementation.lowestCommonAncestor(sampleHead, node5, node3);
		assertEquals(ancestor,sampleHead);
		assertEquals(1,1);
		System.out.print("buffffffer");
	}

}
