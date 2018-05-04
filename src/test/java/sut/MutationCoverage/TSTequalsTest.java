package sut.MutationCoverage;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sut.TST;

public class TSTequalsTest {
private TST<Integer> trie;
	
	@Before
	public void setUp(){
		trie = new TST<Integer>();
	}
	
	@Test
	public void testNull() {
		assertFalse(trie.equals(null));
	}
	
	@Test
	public void testWithItself() {
		assertTrue(trie.equals(trie));
	}
}
