package sut.LinearCoverageTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import sut.TST;

public class TSTkeysThatMatchTest {

	@Test
	public void testWithNull() {
		long size = new TST<Integer>().keysThatMatch(null).spliterator()
				.getExactSizeIfKnown();
		assertEquals(0,size);
	}

}
