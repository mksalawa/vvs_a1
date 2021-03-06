package sut.BranchAndLineCoverageTesting;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sut.TST;

public class TSTkeysThatMatchTest {

    private TST<Integer> trie;

    @Before
    public void setUp() {
        trie = new TST<>();
    }

    /**
     * Test Case 1
     */
    @Test
    public void testWithNull() {
        assertFalse("Should return empty result for null pattern.",
            trie.keysThatMatch(null).iterator().hasNext());
    }
}
