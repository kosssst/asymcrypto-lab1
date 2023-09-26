package main.generators;

import java.math.BigInteger;

public class BBSGenerator {
    private static final BigInteger P = new BigInteger("D5BBB96D30086EC484EBA3D7F9CAEB07", 16);
    private static final BigInteger Q = new BigInteger("425D2B9BFDB25B9CF6C416CC6E37B59C1F", 16);
    private static final BigInteger N = P.multiply(Q);
    private BigInteger r;

    public BBSGenerator() {
        String generate = BuildInGenerator.generate(64);
        r = new BigInteger(generate, 2);
    }

    public BBSGenerator(int length) {
        this.r = new BigInteger(BuildInGenerator.generate(length), 2);
    }

    public String generate(int length) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            sb.append(r.mod(BigInteger.TWO));

            r = r.pow(2).mod(N);
        }

        return sb.toString();
    }

    public String generateByte() {
        r = r.pow(2).mod(N);

        return r.mod((new BigInteger("256", 16))).toString(16).toUpperCase();
    }
}
