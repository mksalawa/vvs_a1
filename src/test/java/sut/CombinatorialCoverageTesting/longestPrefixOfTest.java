package sut.CombinatorialCoverageTesting;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.Test;

import sut.TST;

/**
 * a = query == null
 * b = query.lenght == 0
 * c = x != null
 * d = i < query.length
 * e = c < x.c
 * f = c > x.c
 * g = x.val != null
 * TR(CoC) = {!a,a,!b,b,c&&d,!c&&d,c&&!d,!c&&!d,!e,e,!f,f,!g,g} // 14
 * @author fc45701
 *
 */
public class longestPrefixOfTest {
	
	private TST<Integer> tree;

	@Before
	public void setUp() {
		tree = new TST<>();
	}
	
	// !a
	@Test
	public void testWithNullValue(){
		assertThrows(IllegalArgumentException.class, () -> {
			tree.longestPrefixOf(null);
	    });	
	 }
	
	// a, !b
	@Test
	public void testWithLengthZero(){
		String input = "";
		assertEquals("Input of length zero gives null result ",null,
				tree.longestPrefixOf(input));
	}
	
	
	//!g,!c&&!d
	@Test
	public void testWithValueNull(){
		String input = "c";
		Integer val = null;
		tree.put(input, val); //insert left
		assertEquals(val,tree.get(input)); //confirm value is there
		assertEquals("Longest of string with val null is empty ","",
				tree.longestPrefixOf(input));
	}
	
	//b, c&&d,c&&!d,e,!e,f,!f,g
	@Test
	public void longestPrefixOfTest1(){
		String input = "c";
		Integer val = 5;
		tree.put("d", val); //insert root
		tree.put("b", val); //insert value on the left
		tree.put(input, val); //insert left
		assertEquals(val,tree.get(input)); //confirm value is there
		assertEquals("Longest of string legnth 1 is string itself ",input,tree.longestPrefixOf(input));
	 }
	
	//!c&&d
	@Test
	public void longestPrefixOfTest2(){
		String input = "cc";
		Integer val = 5;
		tree.put("b", val); //insert left
		assertEquals(val,tree.get("b")); //confirm value is there
		assertEquals("When not present should return empty string ","",tree.longestPrefixOf(input));
	}
	
}
