package io.github.kosssst.asymcryptolab1.generators;

import static main.util.MathUtil.*;

public class WolframGenerator {
    private String seed;
    private final String ZEROS = "0".repeat(32);

    public WolframGenerator() {
        this.seed = BuildInGenerator.generate(32);
        while (this.seed.equals(ZEROS)) {
            this.seed = BuildInGenerator.generate(32);
        }
    }

    public String generate(int length) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append(seed.charAt(31));
            seed = xor(cycleLeft(seed, 1), or(seed, cycleRight(seed, 1)));
        }
        return result.toString();
    }
}
