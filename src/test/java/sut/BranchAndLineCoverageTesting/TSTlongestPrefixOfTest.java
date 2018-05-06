package sut.BranchAndLineCoverageTesting;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.Test;

import sut.TST;

public class TSTlongestPrefixOfTest {
	
	private TST<Integer> trie;

	@Before
	public void setUp() {
		trie = new TST<>();
	}
	
	/**
	* Test Case 1
	*/
	@Test
	public void testWithQueryNull() {
	    assertThrows(IllegalArgumentException.class, () -> {
	    	trie.longestPrefixOf(null);
	    });	
	}
	
	/**
	 * Test Case 2
	 */
	@Test
	public void testWithLenghtZero() {
		assertNull("Query has length zero",
				trie.longestPrefixOf(""));
	}
	
	/**
	 *  Test Case 9
	 */
	@Test
	public void testLongestPrefixOf1() {
		String query = "d";
		trie.put("e",2);
		trie.put("c",6);
		trie.put("d",8);
		String res = trie.longestPrefixOf(query);
		assertEquals(query, res );
	}
	/**
	 * Test Case 10
	 */
	@Test
	public void testLongestPrefixOf2() {
		String query = "e";
		trie.put("e",null);
		String res = trie.longestPrefixOf(query);
		assertNotEquals(query, res );
	}
	
}
