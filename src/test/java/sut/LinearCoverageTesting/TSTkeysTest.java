package sut.LinearCoverageTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import sut.TST;

/**
 * 
 * @author fc45701
 *
 */
public class TSTkeysTest {

	@Test
	public void testWithEmptyObject() {
		TST<Integer> tst = new TST<Integer>();
		assertEquals("Size of empty TST is 0",0,
				tst.keys().spliterator().getExactSizeIfKnown());
	}

}
