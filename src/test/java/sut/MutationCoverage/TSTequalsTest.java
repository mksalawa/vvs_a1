package sut.MutationCoverage;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sut.TST;

/**
 * Kills the mutants present in method equals
 */
public class TSTequalsTest {
	private TST<Integer> trie;
	
	@Before
	public void setUp(){
		trie = new TST<Integer>();
	}
	
	/*
	* kills the mutant that replaces the return of Integer size value with
	* (x == 0 ? 1 : 0)
	*/
	@Test
	public void testWithArgNull() {
		assertFalse(trie.equals(null));
	}
	
	/*
	* Killed the mutant that negated conditional
	*/
	@Test
	public void testWithItself() {
		assertTrue(trie.equals(trie));
	}
	
}
