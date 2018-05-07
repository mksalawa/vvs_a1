package sut;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * TSTLongestPrefixOfEPCTest implements tests satisfying Edge-Pair Coverage criterion for method {@code longestPrefixOf}.
 * <p>
 * Each test is annotated with the test path it implements, according to the Data Flow Graph that can be found in
 * the assignment report.
 */
public class TSTLongestPrefixOfEPCTest {

    private final String MULTIPLE_MS_KEY = "mmmmmmmmmm";
    private final String SINGLE_M_KEY = MULTIPLE_MS_KEY.substring(0, 1);
    private final String HIGHER_CHAR = "p";
    private final String LOWER_CHAR = "k";
    private TST<Integer> tree;

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
     * Test path: (1,3,5,6,7,8,9,6,16)
     */
    @Test
    public void testLeftChildAndReturn() {
        tree.put(MULTIPLE_MS_KEY, 5);

        assertEquals("", tree.longestPrefixOf(LOWER_CHAR));
    }

    /**
     * Test path: (1,3,5,6,7,8,10,11,6,16)
     */
    @Test
    public void testRightChildAndReturn() {
        tree.put(MULTIPLE_MS_KEY, 5);

        assertEquals("", tree.longestPrefixOf(HIGHER_CHAR));
    }

    /**
     * Test path: (1,3,5,6,7,8,10,12,13,15,6,16)
     */
    @Test
    public void testMiddleChildNoValueAndReturn() {
        tree.put(MULTIPLE_MS_KEY, 5);

        assertEquals("", tree.longestPrefixOf(SINGLE_M_KEY));
    }

    /**
     * Test path: (1,3,5,6,7,8,10,11,6,7,8,9,6,7,8,10,11,6,16)
     */
    @Test
    public void testRightLeftRightChildAndReturn() {
        tree.put(MULTIPLE_MS_KEY, 5);
        String multiTsKey = "tttttt";
        String multiPsKey = "ppppp";
        String queryBetweenKeys = "r";
        tree.put(multiTsKey, 3);
        tree.put(multiPsKey, 3);

        assertEquals("", tree.longestPrefixOf(queryBetweenKeys));
    }

    /**
     * Test path: (1,3,5,6,7,8,10,12,13,14,15,6,7,8,9,6,16)
     */
    @Test
    public void testMiddleChildMatchLeftAndReturn() {
        tree.put(MULTIPLE_MS_KEY, 5);
        tree.put(SINGLE_M_KEY, 4);
        String query = SINGLE_M_KEY + LOWER_CHAR;

        assertEquals(SINGLE_M_KEY, tree.longestPrefixOf(query));
    }
}
