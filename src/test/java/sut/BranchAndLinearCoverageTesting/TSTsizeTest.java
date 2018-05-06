package sut.BranchAndLinearCoverageTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import sut.TST;

/**
 * DONE: LINE AND BRANCH COVER
 * @author fc45701
 *
 */
public class TSTsizeTest {

	@Test
	public void testEmptySize() {
		assertEquals("Empty Size",0,new TST<Integer>().size());
	}
	
	@Test
	public void testNotEmpty() {
		TST<Integer> tst = new TST<Integer>();
		tst.put("val", 1);
		assertEquals("Not Empty Size",1,tst.size());
	}

}