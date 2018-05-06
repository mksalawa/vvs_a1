package BranchCoverageTesting;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import sut.TST;

/**
 * DONE: BRANCHED AND LINEAR
 * @author fc45701
 *
 */
public class TestTSTlongestPrefixOf {
	@Test
	public void testWithQueryNull() {
		String query = null;
	    assertThrows(IllegalArgumentException.class, () -> {
	    	new TST<String>().longestPrefixOf(query);
	    });	
	}
	
	@Test
	public void testWithQueryLenghtZero() {
		String query = "";
		assertNull("Query has length zero",
				new TST<String>().longestPrefixOf(query));
	}
	
	@Test
	public void testLongestPrefixOf1() {
		String query = "d";
		TST<Integer> tst = new TST<>();
		tst.put("e",2);
		tst.put("c",6);
		tst.put("d",8);
		String res = tst.longestPrefixOf(query);
		assertEquals(query, res );
	}
	@Test
	public void testLongestPrefixOf2() {
		String query = "e";
		TST<Integer> tst = new TST<>();
		tst.put("e",null);
		String res = tst.longestPrefixOf(query);
		assertNotEquals(query, res );
	}
}
