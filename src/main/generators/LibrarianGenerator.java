package main.generators;

import main.util.TextUtil;

import java.util.Random;

public class LibrarianGenerator {

    private int seed;

    private final String FILEPATH = "src/texts/it.txt";

    private final String text;

    public LibrarianGenerator() {
        text = TextUtil.readFromFile(FILEPATH);
        Random random = new Random();
        seed = random.nextInt(text.length());
    }

    public String generate(int length) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < (int) Math.ceil((double) length / 8); i++) {
            result.append(String.format("%8s", Integer.toBinaryString((int) text.charAt(seed))).replace(" ", "0"));
            if (seed != length) {
                seed += 1;
            } else {
                seed = 0;
            }
        }
        return result.substring(0, length);
    }
}
