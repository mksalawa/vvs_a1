package sut.MutationCoverage;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import sut.TST;

public class TSTkeyswithprefixTest {
private TST<Integer> trie;
	
	@Before
	public void setUp(){
		trie = new TST<Integer>();
	}
	
	@Test
	public void testWithMidElement() {
		String input = "c";
		Integer val = 5;
		trie.put("cc",val - 1);
		assertTrue(trie.keysWithPrefix(input).spliterator().getExactSizeIfKnown() == 1);
	}
}
