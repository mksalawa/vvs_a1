package LinearCoverageTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import sut.TST;

/**
 * DONE: LINE AND BRANCH COVER
 * @author fc45701
 *
 */
public class TestTSTsize {

	@Test
	public void testEmptySize() {
		assertEquals("Empty Size",0,new TST<Integer>().size());
	}
	
	@Test
	public void testNotEmpty() {
		TST<Integer> tst = new TST<Integer>();
		tst.put("val", 1);
		assertEquals("Empty Size",1,tst.size());
	}

}
