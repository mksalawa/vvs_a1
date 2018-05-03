package sut.BranchAndLinearCoverageTesting;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

import sut.TST;

/**
 * DONE: LINE AND BRANCH
 * @author fc45701
 *
 */
public class TSTputTest {

	@Test
	public void testWithKeyNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new TST<Integer>().put(null, 4);
		});	
	}

	@Test
	public void testWithContained() {
		String key = "test";
		Integer val = 4;
		
		TST<Integer> tst = new TST<Integer>();
		tst.put(key, val - 1); //preparation
		assertEquals(new Integer(val - 1), tst.get(key));
		tst.put(key, val);
		assertTrue("Value changed ",tst.get(key) == val);
	}
	@Test
	public void testWithNotContained() {
		String key = "test";
		
		TST<Integer> tst = new TST<Integer>();
		tst.put(key,1);
		assertTrue("Does contain root",tst.contains(key));
	}
}
