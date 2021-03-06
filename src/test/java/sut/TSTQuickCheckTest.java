package sut;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import generators.StringKeyGenerator;
import generators.TSTWithIntValGenerator;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;

/**
 * TSTQuickCheckTest implements tests of the properties of the {@link TST}.
 */
@RunWith(JUnitQuickcheck.class)
public class TSTQuickCheckTest {

    /**
     * 1. The order of insertion of different keys does not change the final tree value.
     */
    @Property
    public void testInsertionOrder(@From(TSTWithIntValGenerator.class) TST<Integer> tst) {
        List<String> keys = getKeyList(tst);
        Collections.shuffle(keys);

        TST<Integer> otherTst = new TST<>();
        keys.forEach(k -> otherTst.put(k, tst.get(k)));

        assertEquals("The order of insertion of different keys should not change the final tree value.",
            tst, otherTst);
    }

    /**
     * 2. If you remove all keys from a tree, the tree must be empty.
     */
    @Property
    public void testRemoveAllKeys(@From(TSTWithIntValGenerator.class) TST<Integer> tst) {
        getKeyList(tst).forEach(tst::delete);

        assertEquals("After removing all keys, TST should be empty.", tst.size(), 0);
    }

    /**
     * 3. Given a tree, inserting and then removing the same key value will not
     * change its initial value.
     */
    @Property
    public void testAddingAndRemovingTheSameKey(@From(TSTWithIntValGenerator.class) TST<Integer> tst,
                                                @From(StringKeyGenerator.class) String key) {
        assumeFalse(tst.contains(key));

        TST<Integer> tstCopy = new TST<>();
        tst.keys().forEach(k -> tstCopy.put(k, tst.get(k)));

        tstCopy.put(key, 10);
        assertNotEquals(tstCopy, tst);
        tstCopy.delete(key);

        assertEquals("Inserting and removing the same key should not change its value.", tst, tstCopy);
    }

    /**
     * 4. Selecting a stricter prefix, keysWithPrefix() returns a strict subset result.
     *    E.g. keysWithPrefix("sub") ⊆ keysWithPrefix("su")
     */
    @Property
    public void testStricterPrefix(@From(TSTWithIntValGenerator.class) TST<Integer> tst,
                                   @From(StringKeyGenerator.class) String key) {
        assumeTrue(key.length() > 1);

        List<String> keys = new ArrayList<>();
        tst.keysWithPrefix(key).forEach(keys::add);

        // prefixLength in [1, key.length() - 1], so that both are non-empty
        int prefixLength = new Random().nextInt(key.length() - 1) + 1;
        String subKey = key.substring(0, prefixLength);
        List<String> keysWithSubKeyPrefix = new ArrayList<>();
        tst.keysWithPrefix(subKey).forEach(keysWithSubKeyPrefix::add);

        // keysWithPrefix(key) ⊆ keysWithPrefix(subKey)
        assertTrue("Selecting a stricter prefix should return a strict subset result.",
            keysWithSubKeyPrefix.containsAll(keys));
    }

    private List<String> getKeyList(TST<Integer> tst) {
        List<String> keys = new ArrayList<>();
        tst.keys().forEach(keys::add);
        return keys;
    }
}