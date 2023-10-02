package test;

import main.util.TextUtil;
import org.apache.commons.math3.distribution.NormalDistribution;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Tests {

    public static boolean criterionOfUniformityOfBits(String sequence, double alpha) {
        Map<String, Integer> bytes = TextUtil.getBytes(sequence);
        double n = (double) sequence.length() / 256;
        NormalDistribution normalDistribution = new NormalDistribution();

        double hi2 = 0;
        for (String b : TextUtil.bytes) {
            hi2 += Math.pow(bytes.get(b) - n, 2) / n;
        }

        double hi2Alpha = Math.sqrt(2 * 255) * normalDistribution.inverseCumulativeProbability(1 - alpha) + 255;

        return hi2 <= hi2Alpha;
    }

    public static boolean criterionOfDistributionIndependenceForBits(String sequence, double alpha) {
        int n = sequence.length() / 2;
        Map<String, Integer> vij = TextUtil.countPairsOfBits(sequence);
        int v0 = vij.get("00") + vij.get("01");
        int v1 = vij.get("10") + vij.get("11");
        int a0 = vij.get("00") + vij.get("10");
        int a1 = vij.get("01") + vij.get("11");

        double hi2 = n * ((Math.pow(vij.get("00"), 2) / ((long) v0 * a0))
                + (Math.pow(vij.get("01"), 2) / ((long) v0 * a1))
                + (Math.pow(vij.get("10"), 2) / ((long) v1 * a0))
                + (Math.pow(vij.get("11"), 2) / ((long) v1 * a1)) - 1);

        NormalDistribution standardDistribution = new NormalDistribution();
        double z = standardDistribution.inverseCumulativeProbability(1 - alpha);
        double hi2Alpha = Math.sqrt(8) * z + 4;

        return hi2 <= hi2Alpha;
    }

    public static boolean criterionOfBinarySequenceHomogeneityForBits(String sequence, double alpha) {
        int r = 16;
        ArrayList<String> subsequences = new ArrayList<>();
        Map<String, Integer> zeros = new HashMap<>();
        Map<String, Integer> ones = new HashMap<>();
        int substringLength = sequence.length() / r;
        NormalDistribution normalDistribution = new NormalDistribution();

        for (int i = 0; i <= sequence.length() - substringLength; i += substringLength) {
            subsequences.add(sequence.substring(i, i + substringLength));
        }

        for (String s : subsequences) {
            zeros.put(s, TextUtil.countMatches(s, '0'));
            ones.put(s, TextUtil.countMatches(s, '1'));
        }

        double hi2 = 0;
        int v0 = 0;
        int v1 = 0;
        for (int j = 0; j < r; j++) {
            v0 += zeros.get(subsequences.get(j));
            v1 += ones.get(subsequences.get(j));
        }
        for (int i = 0; i < r; i++) {
            hi2 += Math.pow(zeros.get(subsequences.get(i)), 2) / ((long) v0 * substringLength);
        }
        for (int i = 0; i < r; i++) {
            hi2 += Math.pow(ones.get(subsequences.get(i)), 2) / ((long) v1 * substringLength);
        }
        hi2 -= 1;
        hi2 *= (r * substringLength);

        double hi2Alpha = Math.sqrt(2 * (r - 1)) * normalDistribution.inverseCumulativeProbability(1 - alpha) + (r - 1);

        return hi2 <= hi2Alpha;
    }
}
