package test;

import main.generators.BBSGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BBSGeneratorBitsTest {
    private final BBSGenerator generator = new BBSGenerator();

    @Test
    void testBBSGeneratorFirstCriterionWithAlpha001() {
        Assertions.assertTrue(Tests.criterionOfUniformityOfBits(generator.generate(2000000), 0.01));
    }

    @Test
    void testBBSGeneratorFirstCriterionWithAlpha005() {
        Assertions.assertTrue(Tests.criterionOfUniformityOfBits(generator.generate(2000000), 0.05));
    }

    @Test
    void testBBSGeneratorFirstCriterionWithAlpha01() {
        Assertions.assertTrue(Tests.criterionOfUniformityOfBits(generator.generate(2000000), 0.1));
    }

    @Test
    void testBBSGeneratorSecondCriterionWithAlpha001() {
        Assertions.assertTrue(Tests.criterionOfDistributionIndependenceForBits(generator.generate(2000000), 0.01));
    }

    @Test
    void testBBSGeneratorSecondCriterionWithAlpha005() {
        Assertions.assertTrue(Tests.criterionOfDistributionIndependenceForBits(generator.generate(2000000), 0.05));
    }

    @Test
    void testBBSGeneratorSecondCriterionWithAlpha01() {
        Assertions.assertTrue(Tests.criterionOfDistributionIndependenceForBits(generator.generate(2000000), 0.1));
    }

    @Test
    void testBBSGeneratorThirdCriterionWithAlpha001() {
        Assertions.assertTrue(Tests.criterionOfBinarySequenceHomogeneityForBits(generator.generate(2000000), 0.01));
    }

    @Test
    void testBBSGeneratorThirdCriterionWithAlpha005() {
        Assertions.assertTrue(Tests.criterionOfBinarySequenceHomogeneityForBits(generator.generate(2000000), 0.05));
    }

    @Test
    void testBBSGeneratorThirdCriterionWithAlpha01() {
        Assertions.assertTrue(Tests.criterionOfBinarySequenceHomogeneityForBits(generator.generate(2000000), 0.1));
    }
}
