package io.github.kosssst.asymcryptolab1.generators;

import java.math.BigInteger;

public class BMGenerator {
    private static final BigInteger P = new BigInteger("CEA42B987C44FA642D80AD9F51F10457690DEF10C83D0BC1BCEE12FC3B6093E3", 16);
    private static final BigInteger A = new BigInteger("5B88C41246790891C095E2878880342E88C79974303BD0400B090FE38A688356", 16);
    private BigInteger T;

    public BMGenerator() {
        String generate = BuildInGenerator.generate(64);
        T = new BigInteger(generate, 2);
    }

    public String generate(int length) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            sb.append(next(T));

            T = A.modPow(T, P);
        }

        return sb.toString();
    }

    public String generateByte(int length) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append(calculateK(T));
            T = A.modPow(T, P);
        }
        return result.toString();
    }

    private String next(BigInteger T) {
        BigInteger num = P.subtract(BigInteger.ONE).divide(BigInteger.TWO);
        boolean condition = T.compareTo(num) == -1;

        return condition ? "0" : "1";
    }

    private String calculateK(BigInteger T) {
        BigInteger unit = P.subtract(BigInteger.ONE).divide(BigInteger.valueOf(256));

        return String.format("%2s", T.divide(unit).toString(16).toUpperCase()).replace(' ', '0');
    }
}
