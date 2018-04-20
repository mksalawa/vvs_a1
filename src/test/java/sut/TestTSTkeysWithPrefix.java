package sut;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * DONE: LINE AND BRANCH COVER
 * @author fc45701
 *
 */
public class TestTSTkeysWithPrefix {

	@Test
	public void testWithNullArgument() {
		String input = null;
	    assertThrows(IllegalArgumentException.class, () -> {
	    	new TST<String>().keysWithPrefix(input);
	    });	
	}
	
	//TODO -> Is it good to do it like this?
	//ASK if its ok to add dependencies
	@Test
	public void testWithNoRoot() {
		String input = "test";
		List<String> lst = new ArrayList<>();
		for( String s :  new TST<Integer>().keysWithPrefix(input))
			lst.add(s);
		assertEquals("No root means length zero",0,lst.size());
	}
	
	@Test
	public void testWithOnlyRoot() {
		String input = "test";
		List<String> lst = new ArrayList<>();
		TST<Integer> tst = new TST<Integer>();
		tst.put(input, 4);
		for( String s :  tst.keysWithPrefix(input))
			lst.add(s);
		assertEquals("Only root means length 1",1,lst.size());
	}
	
	@Test
	public void testWithOnlyRootAndNullVal() {
		String input = "test";
		List<String> lst = new ArrayList<>();
		TST<Integer> tst = new TST<Integer>();
		tst.put(input, null);
		for( String s :  tst.keysWithPrefix(input))
			lst.add(s);
		assertEquals("Only root with null val means size 0",0,lst.size());
	}

}
