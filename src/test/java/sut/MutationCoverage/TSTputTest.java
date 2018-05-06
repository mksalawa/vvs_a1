package sut.MutationCoverage;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import sut.TST;

public class TSTputTest {
private TST<Integer> trie;
	
	@Before
	public void setUp(){
		trie = new TST<Integer>();
	}
	
	/*
	 * Kills the mutant that negates condition
	 */ 
	@Test
	public void testUpdateValueDoesNotChangeSize() {
		String input = "c";
		Integer val = 5;
		trie.put("d",val + 1);
		trie.put(input,val - 1); //preparation
		trie.put(input,val);
		assertTrue(trie.size() == 2);
	}
}
