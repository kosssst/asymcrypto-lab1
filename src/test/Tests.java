package test;

import main.util.TextUtil;
import org.apache.commons.math3.distribution.NormalDistribution;

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
}
