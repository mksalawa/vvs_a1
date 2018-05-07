package sut.BranchAndLineCoverageTesting;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.Test;

import sut.TST;

public class TSTputTest {

    private TST<Integer> trie;

    @Before
    public void setUp() {
        trie = new TST<>();
    }

    /**
     * Test Case 6
     */
    @Test
    public void testWithKeyNull() {
        assertThrows(IllegalArgumentException.class, () -> trie.put(null, 4));
    }

    /**
     * Test Case 7 -> where we need it to contain it before put
     */
    @Test
    public void testWithContained() {
        String key = "test";
        Integer val = 4;

        trie.put(key, val - 1); //preparation
        assertEquals(new Integer(val - 1), trie.get(key));
        trie.put(key, val);
        assertTrue("Value changed ", trie.get(key) == val);
    }

    /**
     * Test Case 8
     */
    @Test
    public void testWithNotContained() {
        String key = "test";

        trie.put(key, 1);
        assertTrue("Does contain root", trie.contains(key));
    }
}
