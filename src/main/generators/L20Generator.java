package main.generators;

public class L20Generator {
    private static final String ZEROS = "0".repeat(20);
    private String seed;

    public L20Generator() {
        seed = BuildInGenerator.generate(20);

        while (seed.equals(ZEROS)) {
            seed = BuildInGenerator.generate(20);
        }
    }

    public L20Generator(String seed) throws Exception {
        this.seed = String.format("%20s", seed).replace(' ', '0');
        if (this.seed.equals(ZEROS)) throw new Exception("Seed can not be zero");
    }

    public L20Generator(int seed) throws Exception {
        seed %= (int) Math.pow(2, 20);
        this.seed = String.format("%20s", Integer.toBinaryString(seed)).replace(' ', '0');
        if (this.seed.equals(ZEROS)) throw new Exception("Seed can not be zero");
    }

    public String generate(int length) {
        String sequence = this.seed;

        if (length <= 20) return sequence.substring(0, length);

        for (int i = 0; i < length-20; i++) {
            sequence += next(sequence);
        }

        return sequence;
    }

    private int next(String sequence) {
        int x0 = sequence.charAt(sequence.length() - 20) - '0';
        int x11 = sequence.charAt(sequence.length() - 9) - '0';
        int x15 = sequence.charAt(sequence.length() - 5) - '0';
        int x17 = sequence.charAt(sequence.length() - 3) - '0';
        return x17 ^ x15 ^ x11 ^ x0;
    }
}
