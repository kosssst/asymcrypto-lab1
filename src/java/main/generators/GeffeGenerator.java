package main.generators;

public class GeffeGenerator {
    private String seedX;
    private String seedY;
    private String seedS;

    public GeffeGenerator() {
        this.seedX = BuildInGenerator.generate(11);
        this.seedY = BuildInGenerator.generate(9);
        this.seedS = BuildInGenerator.generate(10);
    }

    public String generate(int length) {
        StringBuilder z = new StringBuilder();

        for (int i = 0; i < length; i++) {
            z.append(next(seedX.charAt(0), seedY.charAt(0), seedS.charAt(0)));
            seedX += nextL11(seedX);
            seedY += nextL9(seedY);
            seedS += nextL10(seedS);
            seedX = seedX.substring(1);
            seedY = seedY.substring(1);
            seedS = seedS.substring(1);
        }

        return z.toString();
    }

    private int next(char x, char y, char s) {
        int lastX = x - '0';
        int lastY = y - '0';
        int lastS = s - '0';
        return lastS & lastX ^ (1 ^ lastS) & lastY;
    }

    private int nextL9(String seed) {
        int x0 = seed.charAt(seed.length() - 9) - '0';
        int x1 = seed.charAt(seed.length() - 8) - '0';
        int x3 = seed.charAt(seed.length() - 6) - '0';
        int x4 = seed.charAt(seed.length() - 5) - '0';
        return x0 ^ x1 ^ x3 ^ x4;
    }

    private int nextL10(String seed) {
        int x0 = seed.charAt(seed.length() - 10) - '0';
        int x3 = seed.charAt(seed.length() - 7) - '0';
        return x0 ^ x3;
    }

    private int nextL11(String seed) {
        int x0 = seed.charAt(seed.length() - 11) - '0';
        int x2 = seed.charAt(seed.length() - 9) - '0';
        return x0 ^ x2;
    }
}
