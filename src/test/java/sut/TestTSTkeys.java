package sut;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestTSTkeys {

	@Test
	public void testWithEmptyObject() {
		TST<Integer> tst = new TST<Integer>();
		ArrayList<String> res =new ArrayList<>();
		for(String k : tst.keys())
			res.add(k);
		assertEquals("Size of empty TST is 0",0, res.size());
	}

}
