package sut.BranchAndLineCoverageTesting;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.Test;

import sut.TST;

public class TSTkeysWithPrefixTest {

    private TST<Integer> trie;

    @Before
    public void setUp() {
        trie = new TST<>();
    }

    /**
     * Test Case 1
     */
    @Test
    public void testWithNullArgument() {
        assertThrows(IllegalArgumentException.class, () -> trie.keysWithPrefix(null));
    }

    /**
     * Test Case 3
     */
    @Test
    public void testWithNoRoot() {
        String input = "test";
        assertFalse("Should return empty result if no root.", trie.keysWithPrefix(input).iterator().hasNext());
    }

    /**
     * Test Case 5
     */
    @Test
    public void testWithOnlyRoot() {
        String input = "test";
        trie.put(input, 4);
        long size = trie.keysWithPrefix(input).spliterator().getExactSizeIfKnown();
        assertEquals("Only root means size 1", 1, size);
    }

    /**
     * Test Case 4
     */
    @Test
    public void testWithOnlyRootAndNullVal() {
        String input = "test";
        trie.put(input, null);
        assertFalse("Only root with null val means size 0", trie.keysWithPrefix(input).iterator().hasNext());
    }
}
