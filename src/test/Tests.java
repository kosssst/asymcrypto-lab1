package test;

import main.util.TextUtil;
import org.apache.commons.math3.distribution.NormalDistribution;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Tests {

    public static boolean criterionOfUniformityOfBits(String sequence, double alpha) {
        Map<String, Integer> bytes = TextUtil.getBytes(sequence);
        double n = (double) sequence.length() / 512;
        NormalDistribution normalDistribution = new NormalDistribution();

        double hi2 = 0;
        for (String b : TextUtil.bytes) {
            if (bytes.containsKey(b)) {
                hi2 += Math.pow(bytes.get(b) - n, 2) / n;
            }
        }

        double hi2Alpha = Math.sqrt(2 * 255) * normalDistribution.inverseCumulativeProbability(1 - alpha) + 255;

        System.out.println("First test, a = " + alpha + " , hi2 = " + hi2 + ", hi2(1-a) = " + hi2Alpha);

        return hi2 <= hi2Alpha;
    }

    public static boolean criterionOfDistributionIndependenceForBits(String sequence, double alpha) {
        int n = sequence.length() / 4;
        Map<ArrayList<String>, Integer> pairs = TextUtil.countPairs(sequence);
        NormalDistribution normalDistribution = new NormalDistribution();

        double hi2 = 0;
        for (String i : TextUtil.bytes) {
            for (String j : TextUtil.bytes) {
                ArrayList<String> pair = new ArrayList<>(List.of(i, j));
                int first = TextUtil.countPairsWithByteInFirstPlace(pairs, i);
                int second = TextUtil.countPairsWithByteInSecondPlace(pairs, j);
                hi2 += Math.pow(pairs.get(pair), 2) / ((long) first * second);
            }
        }
        hi2 = (hi2 - 1) * n;

        double hi2Alpha = Math.sqrt(2 * Math.pow(255, 2)) * normalDistribution.inverseCumulativeProbability(1 - alpha) + Math.pow(255, 2);

        System.out.println("Second test, a = " + alpha + " , hi2 = " + hi2 + ", hi2(1-a) = " + hi2Alpha);

        return hi2 <= hi2Alpha;
    }

    public static boolean criterionOfBinarySequenceHomogeneityForBits(String sequence, double alpha) {
        int r = 32;
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
                hi2 += Math.pow(TextUtil.countMatchedBytes(j, i), 2) / ( sumOfByte * ((double) substringLength / 2));
            }
        }
        hi2 = (hi2 - 1) * (((double) substringLength / 2) * r);

        double hi2Alpha = Math.sqrt(2 * 255 * (r - 1)) * normalDistribution.inverseCumulativeProbability(1 - alpha) + (255 * (r - 1));

        System.out.println("Third test, a = " + alpha + " , hi2 = " + hi2 + ", hi2(1-a) = " + hi2Alpha);

        return hi2 <= hi2Alpha;
    }
}
