package sut.BranchAndLinearCoverageTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import sut.TST;

public class TSTsizeTest {

	/**
	 * Test Case 0
	 */
	@Test
	public void testEmptySize() {
		assertEquals("Empty Size",0,new TST<Integer>().size());
	}
	

}
