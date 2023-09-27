package main.generators;

import java.util.Random;

public class LehmerLowGenerator {
    private static final int M = (int) Math.pow(2, 32);
    private static final int A = (int) Math.pow(2, 16) + 1;
    private static final int C = 119;
    private int seed;

    public LehmerLowGenerator() {
        seed = new Random().nextInt();
    }

    public LehmerLowGenerator(int seed) {
        this.seed = seed;
    }

    public String generate() {
        seed = next(seed);
        String seedString = String.format("%32s", Integer.toBinaryString(seed))
                .replace(' ', '0');
        return seedString.substring(24);
    }

    private int next(int seed) {
        return (A * seed + C) % M;
    }
}
