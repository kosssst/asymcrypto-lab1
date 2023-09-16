package main;

import java.util.Random;

public class LehmerGenerator {
    private static final int M = (int) Math.pow(2, 32);
    private static final int A = (int) Math.pow(2, 16) + 1;
    private static final int C = 119;
    private int seed;

    public LehmerGenerator() {
        seed = new Random().nextInt();
    }

    public LehmerGenerator(int seed) {
        this.seed = seed;
    }

    public int lehmerHigh() {
        generate();
        String s = Integer.toBinaryString(seed);
        StringBuilder sb = new StringBuilder();

        if (s.length() <= 8) {
            return Integer.parseInt(s, 2);
        }

        for (int i = 0; i < 8; i++) {
            sb.append(s.charAt(i));
        }

        return Integer.parseInt(sb.toString(), 2);
    }

    public int lehmerLow() {
        generate();
        return seed & 0xFF;
    }

    private void generate() {
        this.seed = (A * this.seed + C) % M;
    }

}