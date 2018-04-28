package sut.BranchCoverageTesting;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

import sut.TST;

/**
 * DONE: LINE AND BRANCH COVER
 * @author fc45701
 *
 */
public class TSTkeysWithPrefixTest {

	@Test
	public void testWithNullArgument() {
	    assertThrows(IllegalArgumentException.class, () -> {
	    	new TST<String>().keysWithPrefix(null);
	    });	
	}
	
	@Test
	public void testWithNoRoot() {
		String input = "test";
		long size = new TST<Integer>().keysWithPrefix(input).spliterator()
				.getExactSizeIfKnown();
		assertEquals("No root means length zero",0,size);
	}
	
	@Test
	public void testWithOnlyRoot() {
		String input = "test";
		TST<Integer> tst = new TST<Integer>();
		tst.put(input, 4);
		long size = tst.keysWithPrefix(input).spliterator()
				.getExactSizeIfKnown();
		assertEquals("Only root means length 1",1,size);
	}
	
	@Test
	public void testWithOnlyRootAndNullVal() {
		String input = "test";
		TST<Integer> tst = new TST<Integer>();
		tst.put(input, null);
		long size = tst.keysWithPrefix(input).spliterator()
				.getExactSizeIfKnown();
		assertEquals("Only root with null val means size 0",0,size);
	}

}
