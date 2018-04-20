package sut;

import static org.junit.Assert.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

//TODO> ask, is this a good idea?
/**
 * DONE: Line and Branch Cover
 * @author fc45701
 *
 */
public class TestTSTget {
	
	//TODO -> duvido que seja boa pratica fazer assim
	@Test
	public void testWithNullArgument() {
		String input = null;
	    assertThrows(IllegalArgumentException.class, () -> {
	    	new TST<String>().get(input);
	    });	
	}
	
	//TODO -> duvido que seja boa pratica fazer assim
	@Test
	public void testWithLenghtZero() {
		String input = "";
		assertThrows(IllegalArgumentException.class, () -> {
		    new TST<String>().get(input);
		});	
	}
	
	//TODO -> duvido que seja boa pratica fazer assim
	@Test
	public void testWithGetNull() {
		String input = "test";
		assertNull(new TST<String>().get(input));
	}
	
	//TODO -> change name maybe?
	@Test
	public void testGet() {
		TST<Integer> tst = new TST<Integer>();
		String input = "test";
		Integer val = 4;
		tst.put(input, val);
		assertEquals("getting root value",tst.get(input),val);
	}
}
