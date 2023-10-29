package main.generators;

public class L89Generator {
    private static final String ZEROS = "0".repeat(89);
    private String seed;

    public L89Generator() {
        seed = BuildInGenerator.generate(89);

        while (seed.equals(ZEROS)) {
            seed = BuildInGenerator.generate(89);
        }
    }

    public L89Generator(String seed) throws Exception {
        this.seed = String.format("%89s", seed).replace(' ', '0');
        if (this.seed.equals(ZEROS)) throw new Exception("Seed can not be zero");
    }

    public String generate(int length) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < length; i++) {
            result.append(seed.charAt(0));
            seed += next(seed);
            seed = seed.substring(1);
        }

        return result.toString();
    }

    private int next(String sequence) {
        int x0 = sequence.charAt(sequence.length() - 89) - '0';
        int x51 = sequence.charAt(sequence.length() - 38) - '0';
        return x51 ^ x0;
    }
}
