package sut.BranchAndLinearCoverageTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import sut.TST;

public class TSTkeysThatMatchTest {

	/**
	* Test Case 1
	*/
	@Test
	public void testWithNull() {
		long size = new TST<Integer>().keysThatMatch(null).spliterator()
				.getExactSizeIfKnown();
		assertEquals(0,size);
	}

}
