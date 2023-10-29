package test;

import main.generators.LehmerLowGenerator;
import main.util.TextUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LehmerLowGeneratorTest {
    private static final LehmerLowGenerator generator = new LehmerLowGenerator();
    private static final String output = TextUtil.bitsToBytes(generator.generate(16000000));
    
    @Test
    void testLehmerLowGeneratorFirstCriterionWithAlpha001() {
        Assertions.assertTrue(Tests.criterionOfUniformityOfBits(output, 0.01));
    }

    @Test
    void testLehmerLowGeneratorFirstCriterionWithAlpha005() {
        Assertions.assertTrue(Tests.criterionOfUniformityOfBits(output, 0.05));
    }

    @Test
    void testLehmerLowGeneratorFirstCriterionWithAlpha01() {
        Assertions.assertTrue(Tests.criterionOfUniformityOfBits(output, 0.1));
    }

    @Test
    void testLehmerLowGeneratorSecondCriterionWithAlpha001() {
        Assertions.assertTrue(Tests.criterionOfDistributionIndependenceForBits(output, 0.01));
    }

    @Test
    void testLehmerLowGeneratorSecondCriterionWithAlpha005() {
        Assertions.assertTrue(Tests.criterionOfDistributionIndependenceForBits(output, 0.05));
    }

    @Test
    void testLehmerLowGeneratorSecondCriterionWithAlpha01() {
        Assertions.assertTrue(Tests.criterionOfDistributionIndependenceForBits(output, 0.1));
    }

    @Test
    void testLehmerLowGeneratorThirdCriterionWithAlpha001() {
        Assertions.assertTrue(Tests.criterionOfBinarySequenceHomogeneityForBits(output, 0.01));
    }

    @Test
    void testLehmerLowGeneratorThirdCriterionWithAlpha005() {
        Assertions.assertTrue(Tests.criterionOfBinarySequenceHomogeneityForBits(output, 0.05));
    }

    @Test
    void testLehmerLowGeneratorThirdCriterionWithAlpha01() {
        Assertions.assertTrue(Tests.criterionOfBinarySequenceHomogeneityForBits(output, 0.1));
    }
}