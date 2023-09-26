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

    public int generate() {
        seed = next(seed);
        return seed & 0xFF;
    }

    private int next(int seed) {
        return (A * seed + C) % M;
    }
}
