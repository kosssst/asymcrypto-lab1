package test;

import main.generators.BMGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BMGeneratorBitsTest {
    private final BMGenerator generator = new BMGenerator();

    @Test
    void testBMGeneratorFirstCriterionWithAlpha001() {
        Assertions.assertTrue(Tests.criterionOfUniformityOfBits(generator.generate(2000000), 0.01));
    }

    @Test
    void testBMGeneratorFirstCriterionWithAlpha005() {
        Assertions.assertTrue(Tests.criterionOfUniformityOfBits(generator.generate(2000000), 0.05));
    }

    @Test
    void testBMGeneratorFirstCriterionWithAlpha01() {
        Assertions.assertTrue(Tests.criterionOfUniformityOfBits(generator.generate(2000000), 0.1));
    }

    @Test
    void testBMGeneratorSecondCriterionWithAlpha001() {
        Assertions.assertTrue(Tests.criterionOfDistributionIndependenceForBits(generator.generate(2000000), 0.01));
    }

    @Test
    void testBMGeneratorSecondCriterionWithAlpha005() {
        Assertions.assertTrue(Tests.criterionOfDistributionIndependenceForBits(generator.generate(2000000), 0.05));
    }

    @Test
    void testBMGeneratorSecondCriterionWithAlpha01() {
        Assertions.assertTrue(Tests.criterionOfDistributionIndependenceForBits(generator.generate(2000000), 0.1));
    }

    @Test
    void testBMGeneratorThirdCriterionWithAlpha001() {
        Assertions.assertTrue(Tests.criterionOfBinarySequenceHomogeneityForBits(generator.generate(2000000), 0.01));
    }

    @Test
    void testBMGeneratorThirdCriterionWithAlpha005() {
        Assertions.assertTrue(Tests.criterionOfBinarySequenceHomogeneityForBits(generator.generate(2000000), 0.05));
    }

    @Test
    void testBMGeneratorThirdCriterionWithAlpha01() {
        Assertions.assertTrue(Tests.criterionOfBinarySequenceHomogeneityForBits(generator.generate(2000000), 0.1));
    }
}
