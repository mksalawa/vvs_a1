package generators;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

public class StringKeyGenerator extends Generator<String> {

    private static final int MAX_KEY_LENGTH = 50;

    public StringKeyGenerator(Class<String> type) {
        super(type);
    }

    @Override
    public String generate(SourceOfRandomness src, GenerationStatus status) {
        int keyLength = src.nextInt(1, MAX_KEY_LENGTH);
        StringBuilder key = new StringBuilder();
        for (int j = 0; j < keyLength; j++) {
            key.append(src.nextChar('a', 'z'));
        }
        return key.toString();
    }
}
