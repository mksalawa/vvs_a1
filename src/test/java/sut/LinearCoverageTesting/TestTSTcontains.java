package LinearCoverageTesting;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

import sut.TST;

/**
 * DONE: Line and Branch Cover
 * @author fc45701
 *
 */
public class TestTSTcontains {
	
	@Test
	public void testWithNullArgument() {
		String input = null;
	    assertThrows(IllegalArgumentException.class, () -> {
	    	new TST<String>().contains(input);
	    });	
	}

	@Test
	public void testContains() {
		TST<Integer> tst = new TST<Integer>();
		String input = "test";
		Integer val = 4;
		tst.put(input, val);
	    assertTrue("Contains value",tst.contains(input));
	}

}