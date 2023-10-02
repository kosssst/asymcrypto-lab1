package test;

import main.util.TextUtil;
import org.apache.commons.math3.distribution.NormalDistribution;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        Map<ArrayList<String>, Integer> pairs = TextUtil.countPairs(sequence);
        NormalDistribution normalDistribution = new NormalDistribution();

        double hi2 = 0;
        for (String i : TextUtil.bytes) {
            for (String j : TextUtil.bytes) {
                ArrayList<String> pair = new ArrayList<>(List.of(i, j));
                hi2 += Math.pow(pairs.get(pair), 2) / ((long) TextUtil.countPairsWithByteInFirstPlace(pairs, i) * TextUtil.countPairsWithByteInSecondPlace(pairs, j));
            }
        }
        hi2 = (hi2 - 1) * n;

        double hi2Alpha = Math.sqrt(2 * Math.pow(255, 2)) * normalDistribution.inverseCumulativeProbability(1 - alpha) + Math.pow(255, 2);

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
