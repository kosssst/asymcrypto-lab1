package main.generators;

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

    private String xor(String a, String b) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            result.append((a.charAt(i) - '0') ^ (b.charAt(i) - '0'));
        }
        return result.toString();
    }

    private String or(String a, String b) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            result.append((a.charAt(i) - '0') | (b.charAt(i) - '0'));
        }
        return result.toString();
    }

    private String cycleLeft(String a, int n) {
        for (int i = 0; i < n; i++) {
            char temp = a.charAt(0);
            a = a.substring(1);
            a += temp;
        }
        return a;
    }

    private String cycleRight(String a, int n) {
        for (int i = 0; i < n; i++) {
            char temp = a.charAt(31);
            a = a.substring(0, 31);
            a = temp + a;
        }
        return a;
    }
}
