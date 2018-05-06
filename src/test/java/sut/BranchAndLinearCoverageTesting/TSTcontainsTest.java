package sut.BranchAndLinearCoverageTesting;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

import sut.TST;

public class TSTcontainsTest {
	
	/**
	 * Test Case 2
	 */
	@Test
	public void testWithNullArgument() {
	    assertThrows(IllegalArgumentException.class, () -> {
	    	new TST<String>().contains(null);
	    });	
	}

	/*
	 * Test Case 4
	 */
	@Test
	public void testContains() {
		TST<Integer> tst = new TST<Integer>();
		String input = "test";
		Integer val = 4;
		tst.put(input, val);
	    assertTrue("Contains value",tst.contains(input));
	}

}
