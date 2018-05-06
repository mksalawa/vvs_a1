package LinearCoverageTesting;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import sut.TST;

public class TestTSTkeysThatMatch {

	@Test
	public void testWithNull() {
		long size = new TST<Integer>().keysThatMatch(null).spliterator()
				.getExactSizeIfKnown();
		assertEquals(0,size);
	}

}
