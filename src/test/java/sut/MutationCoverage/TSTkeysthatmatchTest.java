package sut.MutationCoverage;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import sut.TST;

public class TSTkeysthatmatchTest {

	private TST<Integer> trie;
	
	@Before
	public void setUp(){
		trie = new TST<Integer>();
	}
	
	@Test
	public void testWithOneElement() {
		String input = "c";
		Integer val = 5;
		trie.put("d",val - 1);
		assertTrue(trie.keysThatMatch(input).spliterator().getExactSizeIfKnown() == 0);
	}
	
	@Test
	public void testWithOneElementOnTheRight() {
		String input = "c";
		Integer val = 5;
		trie.put("b",val - 1);
		assertTrue(trie.keysThatMatch(input).spliterator().getExactSizeIfKnown() == 0);
	}
	
	@Test
	public void testWithValInTheMiddle() {
		String input = "cc";
		Integer val = 5;
		trie.put(input,val - 1);
		assertTrue(trie.keysThatMatch(input).spliterator().getExactSizeIfKnown() == 1);
	}
	
	@Test
	public void testWithSmallerInput() {
		String input = "c";
		Integer val = 5;
		trie.put(input + input + input,val - 2);
		trie.put(input + input ,val - 1);
		assertTrue(trie.keysThatMatch(input).spliterator().getExactSizeIfKnown() == 0);
	}
	
	@Test
	public void testWithValOnTheRight() {
		String input = "cc";
		Integer val = 5;
		trie.put("bb",val - 1);
		trie.put(input,val);
		assertTrue(trie.keysThatMatch(input).spliterator().getExactSizeIfKnown() == 1);
	}
	
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
	
	@Test
	public void testWithDot() {
		String input = ".c";
		Integer val = 5;
		trie.put("bb",val - 1);
		trie.put(input,val);
		assertTrue(trie.keysThatMatch(input).spliterator().getExactSizeIfKnown() == 1);
	}
	
}
