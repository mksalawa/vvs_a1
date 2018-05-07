package sut.BranchAndLineCoverageTesting;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.Test;

import sut.TST;

public class TSTcontainsTest {

    private TST<Integer> trie;

    @Before
    public void setUp() {
        trie = new TST<>();
    }

    /**
     * Test Case 2
     */
    @Test
    public void testWithNullArgument() {
        assertThrows(IllegalArgumentException.class, () -> {
            trie.contains(null);
        });
    }

    /**
     * Test Case 4
     */
    @Test
    public void testContainsWithSingleValue() {
        String input = "test";
        Integer val = 4;
        trie.put(input, val);
        assertTrue("Contains value", trie.contains(input));
    }
}
