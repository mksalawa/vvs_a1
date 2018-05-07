package sut.MutationCoverage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import sut.TST;

/**
 * Kills the Mutants present in keysThatMatch
 */
public class TSTkeysThatMatchTest {

    private TST<Integer> trie;

    @Before
    public void setUp() {
        trie = new TST<>();
    }

    /**
     * Kills the mutants that changed conditional boundary and
     * replaces index subtraction with addition
     */
    @Test
    public void testWithSmallestInput() {
        String input = "c";
        Integer val = 5;
        trie.put(input + input + input, val - 2);
        trie.put(input + input, val - 1);
        assertFalse(trie.keysThatMatch(input).iterator().hasNext());
    }

    /**
     * Kills 2 negated condition and a removed called to collect
     */
    @Test
    public void testWithValOnTheRight() {
        String input = "cc";
        Integer val = 5;
        trie.put("bb", val - 1);
        trie.put(input, val);
        assertEquals(1, trie.keysThatMatch(input).spliterator().getExactSizeIfKnown());
    }

    /**
     * Killed negated condition and changed conditional boundary
     */
    @Test
    public void testWithMultipleWrongValues() {
        String input = "cab";
        Integer val = 5;
        trie.put("d", val - 1);
        trie.put("ca", val - 3);
        trie.put("e", val - 1);
        trie.put(input, val);
        assertEquals(1, trie.keysThatMatch(input).spliterator().getExactSizeIfKnown());
    }
}
