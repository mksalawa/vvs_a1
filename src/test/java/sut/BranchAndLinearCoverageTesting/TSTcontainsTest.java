package sut.BranchAndLinearCoverageTesting;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

import sut.TST;

/**
 * DONE: Line and Branch Cover
 * @author fc45701
 *
 */
public class TSTcontainsTest {
	
	@Test
	public void testWithNullArgument() {
	    assertThrows(IllegalArgumentException.class, () -> {
	    	new TST<String>().contains(null);
	    });	
	}

	@Test
	public void testContains() {
		TST<Integer> tst = new TST<Integer>();
		String input = "Random";
		Integer val = 4;
		tst.put(input, val);
	    assertTrue("Contains value",tst.contains(input));
	}

}
