package sut;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TSTLastIndexOfPPCTest {

    private TST<Integer> tree;
    private String MULTIPLE_MS_KEY = "mmmmmmmmmm";
    private final String SINGLE_M_KEY = MULTIPLE_MS_KEY.substring(0, 1);
    private final String HIGHER_CHAR = "p";
    private final String LOWER_CHAR = "k";

    @Before
    public void setUp() {
        tree = new TST<>();
    }

    /**
     * Test path: (1,2)
     */
    @Test
    public void testNullQuery() {
        assertThrows(IllegalArgumentException.class, () -> tree.longestPrefixOf(null));
    }

    /**
     * Test path: (1,3,4)
     */
    @Test
    public void testEmptyQuery() {
        assertNull(tree.longestPrefixOf(""));
    }

    /**
     * Test path: (1,3,5,6,16)
     */
    @Test
    public void testNullRoot() {
        assertEquals("", tree.longestPrefixOf("a"));
    }

    /**
     * Test path: (1,3,5,6,7,8,10,12,13,14,15,6,7,8,9,6,16)
     */
    @Test
    public void testMiddleChildMatchLeftAndReturn() {
        tree.put(MULTIPLE_MS_KEY, 5);
        tree.put(SINGLE_M_KEY, 5);
        String query = SINGLE_M_KEY + LOWER_CHAR;

        assertEquals(SINGLE_M_KEY, tree.longestPrefixOf(query));
    }

    /**
     * Test path: (1,3,5,6,7,8,9,6,7,8,10,12,13,14,15,6,16)
     */
    @Test
    public void testLeftChildMiddleMatchAndReturn() {
        tree.put(MULTIPLE_MS_KEY, 5);
        tree.put(LOWER_CHAR, 5);

        assertEquals(LOWER_CHAR, tree.longestPrefixOf(LOWER_CHAR));
    }

    /**
     * Test path: (1,3,5,6,7,8,10,12,13,14,15,6,7,8,10,12,13,15,6,16)
     */
    @Test
    public void testMiddleChildMatchMiddleNoValAndReturn() {
        tree.put(MULTIPLE_MS_KEY, 5);
        tree.put(SINGLE_M_KEY, 5);

        assertEquals(SINGLE_M_KEY,
            tree.longestPrefixOf(SINGLE_M_KEY + SINGLE_M_KEY));
    }

    /**
     * Test path: (1,3,5,6,7,8,10,12,13,14,15,6,7,8,10,12,13,14,15,6,16)
     */
    @Test
    public void testDoubleMiddleChildMatchAndReturn() {
        String doubleM = SINGLE_M_KEY + SINGLE_M_KEY;
        tree.put(doubleM, 5);
        tree.put(SINGLE_M_KEY, 5);

        assertEquals(doubleM, tree.longestPrefixOf(doubleM));
    }

    /**
     * Test path: (1,3,5,6,7,8,10,12,13,15,6,7,8,10,12,13,14,15,6,16)
     */
    @Test
    public void testMiddleChildNoValMiddleMatchAndReturn() {
        String doubleM = SINGLE_M_KEY + SINGLE_M_KEY;
        tree.put(doubleM, 5);

        assertEquals(doubleM, tree.longestPrefixOf(doubleM));
    }

    /**
     * Test path: (1,3,5,6,7,8,10,12,13,14,15,6,7,8,10,11,6,16)
     */
    @Test
    public void testMiddleChildMatchRightAndReturn() {
        tree.put(MULTIPLE_MS_KEY, 5);
        tree.put(SINGLE_M_KEY, 5);

        assertEquals(SINGLE_M_KEY, tree.longestPrefixOf(SINGLE_M_KEY + HIGHER_CHAR));
    }

    /**
     * Test path: (1,3,5,6,7,8,10,11,6,7,8,10,12,13,14,15,6,16)
     */
    @Test
    public void testRightChildMiddleMatchAndReturn() {
        tree.put(MULTIPLE_MS_KEY, 5);
        tree.put(HIGHER_CHAR, 5);

        assertEquals(HIGHER_CHAR, tree.longestPrefixOf(HIGHER_CHAR));
    }

    /**
     * Test path: (1,3,5,6,7,8,10,12,13,15,6,7,8,9,6,16)
     */
    @Test
    public void testMiddleChildNoValueLeftAndReturn() {
        tree.put(MULTIPLE_MS_KEY, 5);
        String query = SINGLE_M_KEY + LOWER_CHAR;

        assertEquals("", tree.longestPrefixOf(query));
    }

    /**
     * Test path: (1,3,5,6,7,8,9,6,7,8,10,12,13,15,6,16)
     */
    @Test
    public void testLeftChildMiddleNoValueAndReturn() {
        tree.put(MULTIPLE_MS_KEY, 5);
        tree.put(LOWER_CHAR + LOWER_CHAR, 5);

        assertEquals("", tree.longestPrefixOf(LOWER_CHAR));
    }

    /**
     * Test path: (1,3,5,6,7,8,10,12,13,15,6,7,8,10,12,13,15,6,16)
     */
    @Test
    public void testDoubleMiddleChildNoValueAndReturn() {
        tree.put(MULTIPLE_MS_KEY, 5);

        assertEquals("", tree.longestPrefixOf(SINGLE_M_KEY + SINGLE_M_KEY));
    }

    /**
     * Test path: (1,3,5,6,7,8,10,12,13,15,6,7,8,10,11,6,16)
     */
    @Test
    public void testMiddleChildNoValueRightAndReturn() {
        tree.put(MULTIPLE_MS_KEY, 5);

        assertEquals("", tree.longestPrefixOf(SINGLE_M_KEY + HIGHER_CHAR));
    }

    /**
     * Test path: (1,3,5,6,7,8,10,11,6,7,8,10,12,13,15,6,16)
     */
    @Test
    public void testRightChildMiddleNoValueAndReturn() {
        tree.put(MULTIPLE_MS_KEY, 5);
        tree.put(HIGHER_CHAR + HIGHER_CHAR, 5);

        assertEquals("", tree.longestPrefixOf(HIGHER_CHAR));
    }

    /**
     * Test path: (1,3,5,6,7,8,9,6,7,8,10,11,6,16)
     */
    @Test
    public void testLeftChildRightAndReturn() {
        tree.put(MULTIPLE_MS_KEY, 5);
        tree.put(LOWER_CHAR, 5);
        String queryBetweenKeys = "l";

        assertEquals("", tree.longestPrefixOf(queryBetweenKeys));
    }

    /**
     * Test path: (1,3,5,6,7,8,10,11,6,7,8,9,6,16)
     */
    @Test
    public void testRightLeftChildAndReturn() {
        tree.put(MULTIPLE_MS_KEY, 5);
        tree.put(HIGHER_CHAR, 5);
        String queryBetweenKeys = "n";

        assertEquals("", tree.longestPrefixOf(queryBetweenKeys));
    }

    /**
     * Test path: (1,3,5,6,7,8,10,11,6,7,8,10,11,6,16)
     */
    @Test
    public void testDoubleRightChildAndReturn() {
        tree.put(MULTIPLE_MS_KEY, 5);
        tree.put(HIGHER_CHAR, 5);
        String queryHigherThanHigher = "t";

        assertEquals("", tree.longestPrefixOf(queryHigherThanHigher));
    }

    /**
     * Test path: (1,3,5,6,7,8,9,6,7,8,9,6,16)
     */
    @Test
    public void testDoubleLeftChildAndReturn() {
        tree.put(MULTIPLE_MS_KEY, 5);
        tree.put(LOWER_CHAR, 5);
        String queryLowerThanLower = "a";

        assertEquals("", tree.longestPrefixOf(queryLowerThanLower));
    }
}
