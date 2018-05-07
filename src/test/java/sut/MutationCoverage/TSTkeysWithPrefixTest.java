package sut.MutationCoverage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import sut.TST;

/**
 * Kills the mutants present in keysWithPrefix
 */
public class TSTkeysWithPrefixTest {
    private TST<Integer> trie;

    @Before
    public void setUp() {
        trie = new TST<>();
    }

    /**
     * Kills the mutant that removes the call to the sut/TST::collect
     */
    @Test
    public void testWithMidElement() {
        String input = "c";
        Integer val = 5;
        trie.put("cc", val - 1);
        assertEquals(1, trie.keysWithPrefix(input).spliterator().getExactSizeIfKnown());
    }
}
