package sut.BranchAndLinearCoverageTesting;

import static org.junit.Assert.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

import sut.TST;

public class TSTgetTest {
	
	/**
	 * Test Case 1
	 */
	@Test
	public void testWithNullArgument() {
		String input = null;
	    assertThrows(IllegalArgumentException.class, () -> {
	    	new TST<String>().get(input);
	    });	
	}
	
	/**
	 * Test Case 2
	 */
	@Test
	public void testWithLenghtZero() {
		String input = "";
		assertThrows(IllegalArgumentException.class, () -> {
		    new TST<String>().get(input);
		});	
	}
	
	/**
	 * Test Case 3
	 */
	@Test
	public void testReturnNullIfKeyNotPresent() {
		String input = "test";
		assertNull(new TST<String>().get(input));
	}
	
	/**
	 * Test Case 4
	 */
	@Test
	public void testGetWithValNull() {
		TST<Integer> tst = new TST<Integer>();
		String input = "test";
		Integer val = null;
		tst.put(input, val);
		assertEquals("getting root value",tst.get(input),val);
	}
}
