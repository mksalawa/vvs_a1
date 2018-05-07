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
 * <p>
 * base choice = {c1,c2,c3,c4} -> {false,true,false,t}
 * {(false,true,false,t),(true,true,false,t),(false,true,true,t),
 * (false,false,false,t),(false,true,false,s),(false,true,false,l)}
 * total = 6
 */
public class TSTputTest {

    private TST<Integer> trie;

    @Before
    public void setUp() {
        trie = new TST<>();
    }

    /**
     * Covers: (false,false,false,t)
     */
    @Test
    public void putTypicalKeyTest() {
        String input = "abcd";
        Integer val = 4;
        trie.put("a", val);
        trie.put("abbcde", val);
        trie.put(input, val);
        assertEquals("Put typical key we should be able to get its val ", val, trie.get(input));
    }

    /**
     * Covers: (true,true,false,t)
     */
    @Test
    public void updateValInTrieTest() {
        String input = "abcd";
        Integer val = 4;
        trie.put("dcdfs", val);
        trie.put(input, val - 1); //insert the new key
        trie.put("ab", val); // add the prefix
        trie.put(input, val); //update the val
        assertEquals("Second put should update val ", val, trie.get(input));
    }

    /**
     * Covers: (false,true,false,t)
     */
    @Test
    public void trieIncludesPrefixTest() {
        String input = "abab";
        Integer val = 4;
        trie.put("ab", val - 1);
        trie.put("tctcc", val - 2);

        trie.put(input, val);
        assertEquals(val, trie.get(input));
    }


    /**
     * Covers: (false,true,false,l)
     */
    @Test
    public void insertlongestKeyTest() {
        String input = "abab";
        Integer val = 4;
        trie.put("ab", val - 1);
        trie.put(input, val);
        assertEquals("Put of the longest key should be able to go get it ", val, trie.get(input));
    }
}
