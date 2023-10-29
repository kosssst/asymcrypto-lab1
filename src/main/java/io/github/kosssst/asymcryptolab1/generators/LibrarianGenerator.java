package io.github.kosssst.asymcryptolab1.generators;

import main.util.TextUtil;

import java.util.Random;

public class LibrarianGenerator {

    private int seed;

    private final String FILEPATH = "src/java/resources/texts/it.txt";

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
            seed += 1;
            if (seed == text.length()) seed = 0;
        }
        return result.substring(0, length);
    }
}
