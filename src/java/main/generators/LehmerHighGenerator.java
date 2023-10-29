package main.generators;

import java.util.Random;

public class LehmerHighGenerator {
    private static final int M = (int) Math.pow(2, 32);
    private static final int A = (int) Math.pow(2, 16) + 1;
    private static final int C = 119;
    private int seed;

    public LehmerHighGenerator() {
        seed = new Random().nextInt();
    }

    public LehmerHighGenerator(int seed) {
        this.seed = seed;
    }

    public String generate(int length) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length/8; i++) {
            seed = next(seed);
            String seedString = String.format("%32s", Integer.toBinaryString(seed))
                    .replace(' ', '0');
            sb.append(seedString.substring(0, 8));
        }

        return sb.toString();
    }

    private int next(int seed) {
        return (A * seed + C) % M;
    }
}
