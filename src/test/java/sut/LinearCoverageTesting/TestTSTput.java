package LinearCoverageTesting;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

import sut.TST;

/**
 * DONE: LINE AND BRANCH
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
	public void testWithNotContained() {
		String key = "test";
		TST<Integer> tst = new TST<Integer>();
		
		assertFalse("Does not contain root",tst.contains(key));
	}
}
