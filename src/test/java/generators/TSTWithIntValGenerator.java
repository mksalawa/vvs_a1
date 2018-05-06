package generators;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import sut.TST;

public class TSTWithIntValGenerator extends Generator<TST<Integer>> {

    private static final int MAX_KEYS_COUNT = 30;
    private static final int MAX_KEY_LENGTH = 50;
    private static final int MAX_VALUE = 10000;

    public TSTWithIntValGenerator(Class<TST<Integer>> type) {
        super(type);
    }

    @Override
    public TST<Integer> generate(SourceOfRandomness src, GenerationStatus status) {
        int keysCount = src.nextInt(1, MAX_KEYS_COUNT);
        TST<Integer> tst = new TST<>();

        for (int i = 0; i < keysCount; i++) {
            int keyLength = src.nextInt(1, MAX_KEY_LENGTH);
            StringBuilder key = new StringBuilder();
            for (int j = 0; j < keyLength; j++) {
                key.append(src.nextChar('a', 'z'));
            }
            tst.put(key.toString(), src.nextInt(MAX_VALUE));
        }
        return tst;
    }
}
