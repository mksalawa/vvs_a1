package sut;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

/**
 * DONE: LINE AND BRANCH
 * TODO: BRANCH -> falta quando contains
 * @author fc45701
 *
 */
public class TestTSTput {

	@Test
	public void testWithKeyNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new TST<Integer>().put(null, 4);
		});	
	}

	@Test
	public void testWithContained() {
		String key = "key";
		Integer val = 4;
		
		TST<Integer> tst = new TST<Integer>();
		tst.put(key, val);
		
		assertTrue("Contains root",tst.contains(key));
	}
	@Test
	public void testWithNotContained() {
		String key = "key";
		Integer val = 4;
		
		TST<Integer> tst = new TST<Integer>();
		
		assertFalse("Does not contain root",tst.contains(key));
	}
}
