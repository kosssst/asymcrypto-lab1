package main.generators;

import main.util.HexUtil;
import java.math.BigInteger;

public class BMGenerator {
    private static final BigInteger P = new BigInteger("CEA42B987C44FA642D80AD9F51F10457690DEF10C83D0BC1BCEE12FC3B6093E3", 16);
    private static final BigInteger A = new BigInteger("5B88C41246790891C095E2878880342E88C79974303BD0400B090FE38A688356", 16);
    //private String T;
    private BigInteger T;
    //private final HexUtil hexUtil = new HexUtil();

    public BMGenerator() {
        String generate = BuildInGenerator.generate(64);
        T = new BigInteger(generate, 2);
    }

    public static void main(String[] args) {
        BMGenerator bmGenerator = new BMGenerator();
        System.out.println(bmGenerator.generate(20));
        System.out.println(bmGenerator.generateByte(1));
    }

    public BMGenerator(int length) {
        this.T = new BigInteger(BuildInGenerator.generate(length), 2);
    }

    public String generate(int length) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            sb.append(next(T));

            //T = hexUtil.pow(T, A, P);
            T = A.modPow(T, P);
        }

        return sb.toString();
    }

    public String generateByte(int length) {
        T = A.modPow(T, P);
        return nextByte(T);
    }

    private String next(BigInteger T) {
        //String num = hexUtil.divide(hexUtil.sub(T, "1"), "2");
        //boolean condition = hexUtil.compare(T, num) == -1;

        BigInteger num = P.subtract(BigInteger.ONE).divide(BigInteger.TWO);
        boolean condition = T.compareTo(num) == -1;

        return condition ? "0" : "1";
    }

    private String nextByte(BigInteger T) {
        //long k = 1;
        BigInteger unit = P.subtract(BigInteger.ONE).subtract(BigInteger.valueOf(256));

        //while (true) {
        //    if (T.compareTo(unit.multiply(BigInteger.valueOf(k))) == -1
        //            && T.compareTo(unit.multiply(BigInteger.valueOf(k + 1))) >= 0) {
        //        break;
        //    }
        //    k++;
        //}

        return T.divide(unit).toString(16);
    }

}
