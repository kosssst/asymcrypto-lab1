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
        int x0 = sequence.charAt(sequence.length() - 20) - '0';
        int x11 = sequence.charAt(sequence.length() - 9) - '0';
        int x15 = sequence.charAt(sequence.length() - 5) - '0';
        int x17 = sequence.charAt(sequence.length() - 3) - '0';
        return x17 ^ x15 ^ x11 ^ x0;
    }
}
