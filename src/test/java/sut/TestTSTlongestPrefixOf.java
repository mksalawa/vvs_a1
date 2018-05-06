package sut;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
	
	//TODO
	//@ParameterizedTest
	//@ValueSource(strings = { "h", "hello", "asda" })
	@Test
	public void testLongestPrefixOf() {
		String query = "";
		fail("fail");
	}
}
