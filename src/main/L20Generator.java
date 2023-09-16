package main;

public class L20Generator {
    private static final String ZEROS = "0".repeat(20);

    private static int next(String sequence) {
        int x0 = sequence.charAt(sequence.length() - 20) - '0';
        int x11 = sequence.charAt(sequence.length() - 9) - '0';
        int x15 = sequence.charAt(sequence.length() - 5) - '0';
        int x17 = sequence.charAt(sequence.length() - 3) - '0';
        return x17 ^ x15 ^ x11 ^ x0;
    }

    public static String generate(int length) {
        String sequence = BuildInGenerator.generate(20);

        while (sequence.equals(ZEROS)) {
            sequence = BuildInGenerator.generate(20);
        }

        if (length <= 20) return sequence.substring(0, length);

        for (int i = 0; i < length-20; i++) {
            sequence += next(sequence);
        }

        return sequence;
    }
}
