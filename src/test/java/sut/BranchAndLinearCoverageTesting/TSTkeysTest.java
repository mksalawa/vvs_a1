package sut.BranchAndLinearCoverageTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import sut.TST;

public class TSTkeysTest {

	/*
	 * Test Case 0
	 */
	@Test
	public void testWithEmptyObject() {
		TST<Integer> tst = new TST<Integer>();
		assertEquals("Size of empty TST is 0",0,
				tst.keys().spliterator().getExactSizeIfKnown());
	}

}
