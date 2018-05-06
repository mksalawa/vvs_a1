package sut.MutationCoverage;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import sut.TST;

/**
 * Kills the Mutants present in keysThatMatch
 */
public class TSTkeysThatMatchTest {

	private TST<Integer> trie;
	
	@Before
	public void setUp(){
		trie = new TST<Integer>();
	}
	/*
	* Kills the mutants that changed conditional boundary and
	* replaces indice subtraction with addition
	*/
	@Test
	public void testWithSmallerInput() {
		String input = "c";
		Integer val = 5;
		trie.put(input + input + input,val - 2);
		trie.put(input + input ,val - 1);
		assertTrue(trie.keysThatMatch(input).spliterator().getExactSizeIfKnown() == 0);
	}
	
	/*
	* Kills 2 negated condition and a removed called to collect
	*/
	@Test
	public void testWithValOnTheRight() {
		String input = "cc";
		Integer val = 5;
		trie.put("bb",val - 1);
		trie.put(input,val);
		assertTrue(trie.keysThatMatch(input).spliterator().getExactSizeIfKnown() == 1);
	}
	
	/*
	* Killed negated condition and changed conditional boundary
	*/
	@Test
	public void testWithMultipleWrongValues() {
		String input = "cab";
		Integer val = 5;
		trie.put("d",val - 1);
		trie.put("ca", val - 3);
		trie.put("e",val - 1);
		trie.put(input,val);
		assertTrue(trie.keysThatMatch(input).spliterator().getExactSizeIfKnown() == 1);
	}
	
}
