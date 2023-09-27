package test;

import main.generators.LehmerLowGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LehmerLowGeneratorTest {
    private final LehmerLowGenerator generator = new LehmerLowGenerator();
    // todo do exception in third's test
    @Test
    void testLehmerLowGeneratorFirstCriterionWithAlpha001() {
        Assertions.assertTrue(Tests.criterionOfUniformityOfBits(generator.generate(), 0.01));
    }

    @Test
    void testLehmerLowGeneratorFirstCriterionWithAlpha005() {
        Assertions.assertTrue(Tests.criterionOfUniformityOfBits(generator.generate(), 0.05));
    }

    @Test
    void testLehmerLowGeneratorFirstCriterionWithAlpha01() {
        Assertions.assertTrue(Tests.criterionOfUniformityOfBits(generator.generate(), 0.1));
    }

    @Test
    void testLehmerLowGeneratorSecondCriterionWithAlpha001() {
        Assertions.assertTrue(Tests.criterionOfDistributionIndependenceForBits(generator.generate(), 0.01));
    }

    @Test
    void testLehmerLowGeneratorSecondCriterionWithAlpha005() {
        Assertions.assertTrue(Tests.criterionOfDistributionIndependenceForBits(generator.generate(), 0.05));
    }

    @Test
    void testLehmerLowGeneratorSecondCriterionWithAlpha01() {
        Assertions.assertTrue(Tests.criterionOfDistributionIndependenceForBits(generator.generate(), 0.1));
    }

    @Test
    void testLehmerLowGeneratorThirdCriterionWithAlpha001() {
        Assertions.assertTrue(Tests.criterionOfBinarySequenceHomogeneityForBits(generator.generate(), 0.01));
    }

    @Test
    void testLehmerLowGeneratorThirdCriterionWithAlpha005() {
        Assertions.assertTrue(Tests.criterionOfBinarySequenceHomogeneityForBits(generator.generate(), 0.05));
    }

    @Test
    void testLehmerLowGeneratorThirdCriterionWithAlpha01() {
        Assertions.assertTrue(Tests.criterionOfBinarySequenceHomogeneityForBits(generator.generate(), 0.1));
    }
}