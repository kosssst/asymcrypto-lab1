package main;

import java.util.Random;

public class BuildInGenerator {

    public static String generate(int length) {
        Random random = new Random();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < length; i++) builder.append(random.nextInt(2));

        return builder.toString();
    }
}
