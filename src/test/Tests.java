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
        int substringLength = sequence.length() / r;
        NormalDistribution normalDistribution = new NormalDistribution();

        for (int i = 0; i <= sequence.length() - substringLength; i += substringLength) {
            subsequences.add(sequence.substring(i, i + substringLength));
        }

        double hi2 = 0;
        for (String i : TextUtil.bytes) {
            for (String j : subsequences) {
                long sumOfByte = 0;
                for (String k : subsequences) {
                    sumOfByte += TextUtil.countMatchedBytes(k, i);
                }
                hi2 += Math.pow(TextUtil.countMatchedBytes(j, i), 2) / ( sumOfByte * substringLength);
            }
        }
        hi2 = (hi2 - 1) * (substringLength * r);

        double hi2Alpha = Math.sqrt(2 * 255 * (r - 1)) * normalDistribution.inverseCumulativeProbability(1 - alpha) + (255 * (r - 1));

        return hi2 <= hi2Alpha;
    }
}
