package sut.BranchAndLineCoverageTesting;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sut.TST;

public class TSTkeysTest {

	private TST<Integer> trie;

	@Before
	public void setUp() {
		trie = new TST<>();
	}
	
	/*
	 * Test Case 0
	 */
	@Test
	public void testWithEmptyObject() {
		assertEquals("Size of empty TST is 0",0,
				trie.keys().spliterator().getExactSizeIfKnown());
	}

}
