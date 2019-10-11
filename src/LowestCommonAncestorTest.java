import static org.junit.Assert.*;

import org.junit.Test;

public class LowestCommonAncestorTest {
	Node<String> sampleHead= new Node<String>("sample head node content");
	BinaryTree sampleTree= new BinaryTree(sampleHead);
	@Test
	public void test() {
		assertEquals(LowestCommonAncestor.findLCA(null, null, sampleTree), null);
	}

}
