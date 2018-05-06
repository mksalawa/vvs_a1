package sut.BranchAndLinearCoverageTesting;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.Test;

import sut.TST;

public class TSTkeysWithPrefixTest {

	private TST<Integer> trie;
	
	@Before
	public void setUp(){
		trie = new TST<>();
	}
	
	/**
	* Test Case 1
	*/
	@Test
	public void testWithNullArgument() {
	    assertThrows(IllegalArgumentException.class, () -> {
	    	trie.keysWithPrefix(null);
	    });	
	}
	
	/**
	 * Test Case 3
	*/ 
	@Test
	public void testWithNoRoot() {
		String input = "test";
		long size = trie.keysWithPrefix(input).spliterator()
				.getExactSizeIfKnown();
		assertEquals("No root means length zero",0,size);
	}
	
	/**
	 * Test Case 5
	 */
	@Test
	public void testWithOnlyRoot() {
		String input = "test";
		trie.put(input, 4);
		long size = trie.keysWithPrefix(input).spliterator()
				.getExactSizeIfKnown();
		assertEquals("Only root means length 1",1,size);
	}
	
	/**
	* Test Case 4
	**/
	@Test
	public void testWithOnlyRootAndNullVal() {
		String input = "test";
		trie.put(input, null);
		long size = trie.keysWithPrefix(input).spliterator()
				.getExactSizeIfKnown();
		assertEquals("Only root with null val means size 0",0,size);
	}
	
}
