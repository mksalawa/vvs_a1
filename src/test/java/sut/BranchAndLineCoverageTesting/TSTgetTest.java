package sut.BranchAndLineCoverageTesting;

import static org.junit.Assert.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.Test;

import sut.TST;

public class TSTgetTest {
	
	private TST<Integer> trie;

	@Before
	public void setUp() {
		trie = new TST<>();
	}
	
	/**
	 * Test Case 1
	 */
	@Test
	public void testWithNullArgument() {
	    assertThrows(IllegalArgumentException.class, () -> {
	    	trie.get(null);
	    });	
	}
	
	/**
	 * Test Case 2
	 */
	@Test
	public void testWithLenghtZero() {
		assertThrows(IllegalArgumentException.class, () -> {
		    trie.get("");
		});	
	}
	
	/**
	 * Test Case 3
	 */
	@Test
	public void testWithKeyNotPresent() {
		String input = "test";
		assertNull(trie.get(input));
	}
	
	/**
	 * Test Case 4
	 */
	@Test
	public void testWithValNull() {
		String input = "test";
		trie.put(input, null);
		assertEquals("getting root value",trie.get(input), null);
	}
}
