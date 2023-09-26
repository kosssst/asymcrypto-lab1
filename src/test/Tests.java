package test;

import main.util.TextUtil;
import org.apache.commons.math3.distribution.NormalDistribution;

import java.util.Map;

public class Tests {

    public static boolean criterionOfUniformityOfBits(String sequence, double alpha) {
        double n = (double) sequence.length() / 2;
        int v0 = TextUtil.countMatches(sequence, '0');
        int v1 = TextUtil.countMatches(sequence, '1');
        double hi2 = (Math.pow(v0 - n, 2) / n) + (Math.pow(v1 - n, 2) / n);
        NormalDistribution standardDistribution = new NormalDistribution();
        double z = standardDistribution.inverseCumulativeProbability(1 - alpha);
        double hi2Alpha = 2 * z + 2;

        return hi2 <= hi2Alpha;
    }

    public static boolean criterionOfDistributionIndependenceForBits(String sequence, double alpha) {
        int n = sequence.length() / 2;
        Map<String, Integer> vij = TextUtil.countPairsOfBits(sequence);
        int v0 = vij.get("00") + vij.get("01");
        int v1 = vij.get("10") + vij.get("11");
        int a0 = vij.get("00") + vij.get("10");
        int a1 = vij.get("01") + vij.get("11");

        double hi2 = n * ((Math.pow(vij.get("00"), 2) / (v0 * a0))
                + (Math.pow(vij.get("01"), 2) / (v0 * a1))
                + (Math.pow(vij.get("10"), 2) / (v1 * a0))
                + (Math.pow(vij.get("11"), 2) / (v1 * a1)) - 1);

        NormalDistribution standardDistribution = new NormalDistribution();
        double z = standardDistribution.inverseCumulativeProbability(1 - alpha);
        double hi2Alpha = Math.sqrt(8) * z + 4;

        return hi2 <= hi2Alpha;
    }
}
