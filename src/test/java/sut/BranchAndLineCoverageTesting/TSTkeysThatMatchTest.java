package sut.BranchAndLineCoverageTesting;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sut.TST;

public class TSTkeysThatMatchTest {

	private TST<Integer> trie;

	@Before
	public void setUp() {
		trie = new TST<>();
	}
	
	/**
	* Test Case 1
	*/
	@Test
	public void testWithNull() {
		long size = trie.keysThatMatch(null).spliterator()
				.getExactSizeIfKnown();
		assertEquals(0,size);
	}

}
