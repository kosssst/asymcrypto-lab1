package main.generators;

import java.security.SecureRandom;
import java.util.Random;
import java.util.stream.Collectors;

public class BuildInGenerator {
    private static final SecureRandom random = new SecureRandom();

    public static String generate(int length) {
        return random.ints(length, 0, 2)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());
    }
}
