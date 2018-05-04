package sut.BaseChoiceCoverage;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sut.TST;

/**
 * C1. Trie arleady includes the new key {true,false}
 * C2. Tire arleady includes some new key prefix {true,false}
 * C3. Trie is empty {true, false}
 * C4. The new key is the smallest/largest/a typical key {s,l,t}
 * @author fc45701
 *
 * base choice = {c1,c2,c3,c4} -> {false,false,false,t}
 * {(false,false,false,t),(true,false,false,t),(false,true,false,t),
 *  (false,false,true,t),(false,false,false,s),(false,false,false,l)}
 *  total = 6
 */
public class TSTputTest {
	
	private TST<Integer> trie;

	@Before
	public void setUp() {
		trie = new TST<>();
	}
	
	/*
	 * Covers: (false,false,false,t)
	 */
	@Test
	public void putTest1(){
		String input = "abcd";
		Integer val = 4;
		trie.put("a",val);
		trie.put("abbcde",val);
		trie.put(input, val);
		assertEquals("Put typical key we should be able to get its val ",val,trie.get(input));
	}
	
	/*
	 * Covers: (true,false,false,t)
	 */
	@Test
	public void updateValInTrieTest(){
		String input = "abcd";
		Integer val = 4;
		trie.put(input, val - 1);
		trie.put(input, val);
		assertEquals("Second put should update val ",val,trie.get(input));
	}
	/*
	 * Covers: (false,true,false,t)
	 */
	@Test
	public void trieIncludesPrefixTest(){
		String input = "abab";
		Integer val = 4;
		trie.put("ab", val - 1);
		trie.put("tctcc", val - 2);
		
		trie.put(input, val);
		assertEquals("Second put should update val ",val,trie.get(input));
	}
	
	//DOUBT: How can it be typical if the trie is empty?
	/**
	 * Covers: (false,false,true,t)
	 */
	@Test
	public void insertTypicalIntoEmptyTest(){
		String input = "abcd";
		Integer val = 4;
		trie.put(input, val);
		assertEquals("Put should 'put' the val so we can get it ",val,trie.get(input));
	}
	
	/**
	 * Covers: (false,false,false,s)
	 */
	@Test
	public void insertSmallestKeyTest(){
		String input = "ab";
		Integer val = 4;
		trie.put("cdc", val - 1);
		trie.put(input, val);
		assertEquals("Put of the smallest key should be able to go get it ",val,trie.get(input));
	}
	
	/**
	 * Covers: (false,false,false,s)
	 */
	@Test
	public void insertlongestKeyTest(){
		String input = "abab";
		Integer val = 4;
		trie.put("cdc", val - 1);
		trie.put(input, val);
		assertEquals("Put of the longest key should be able to go get it ",val,trie.get(input));
	}
	
}
